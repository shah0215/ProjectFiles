package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team23.prototype1.dao.BomDao;
import com.team23.prototype1.model.BomModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class BomController {
    /**
     * 
     * @return Dashboard of BOM table
     * @throws IOException
     */
    @RequestMapping("bomTable")
    public ModelAndView bomTable() throws IOException {
        BomDao dbInstance = new BomDao();
        ModelAndView mv = new ModelAndView("bom");
        mv.addObject("tableData", writeDashboard(dbInstance.bomData));
        mv.addObject("dropDown", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));

        return mv;
    }

    /**
     * 
     * @return Dashboard of BOM with sorted by newest Entries on Top
     * @throws IOException
     */
    @RequestMapping("newestBom")
    public ModelAndView newestBom() throws IOException {
        BomDao dbInstance = new BomDao();
        ModelAndView mv = new ModelAndView("bom");
        mv.addObject("tableData", writeDashboard(dbInstance.sortByNewest()));
        mv.addObject("dropDown", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));

        return mv;
    }

    /**
     * 
     * @return Dashboard of BOM with sorted by oldest Entries on Top
     * @throws IOException
     */
    @RequestMapping("oldestBom")
    public ModelAndView oldestBom() throws IOException {
        BomDao dbInstance = new BomDao();
        ModelAndView mv = new ModelAndView("bom");
        mv.addObject("tableData", writeDashboard(dbInstance.sortByOldest()));
        mv.addObject("dropDown", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));

        return mv;
    }

    /**
     * 
     * @param ppn parentPartNumber
     * @param cpn ChildPartNumber
     * @return Dashboard of BOM table Righ after inserting a new Row
     * @throws IOException
     */
    @RequestMapping("addNewBom")
    public ModelAndView addNewPart(@RequestParam("parentPartNumber") String ppn, @RequestParam("childPart") String cpn)
            throws IOException {

        BomModel object = new BomModel();

        object.setParentPartNumber(ppn);
        object.setChildPartTextLink(cpn);

        BomDao dbInstance = new BomDao();

        dbInstance.addData(object);

        ModelAndView mv = new ModelAndView();

        mv.setViewName("redirectbom");

        mv.addObject("dropDown", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));

        mv.addObject("tableData", writeDashboard(BomDao.bomData));
        return mv;

    }

    /**
     * This deletes the BOM row from User Interface
     * 
     * @param parent
     * @return BOM Dashboard
     * @throws IOException
     */
    @RequestMapping("deleteBom")
    public ModelAndView deleteBom(@RequestParam("id") String parent) throws IOException {

        BomDao.deleteByParent(parent);

        return bomTable();
    }

    /**
     * 
     * @param list of BomModel objects with carrying data from Database
     * @return The table Data populated with HTML code with all the entries in BOM
     *         TABLE
     * @throws IOException
     */
    public String writeDashboard(ArrayList<BomModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            String[] elements = list.get(i).getChildPartTextLink().split(",");
            String childParts = "";
            for (int j = 0; j < elements.length; j++) {

                childParts = childParts + "<option>(" + (j + 1) + ") " + elements[j] + "</option>";
            }

            ss = ss + ("<tr><td>" + list.get(i).getParentPartNumber() + "</td><td><select  id=\"select\">\r\n"
                    + childParts +

                    "</select></td>"

                    + "<td> <a href=\"deleteBom?id=" + list.get(i).getParentPartNumber() + "&index="
                    + list.indexOf(list.get(i)) + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * This method generates the drop down menu in BOM table
     * 
     * @param partTypeIds
     * @param partIds
     * @param revIds
     * @return DropDown HTML code
     */
    public String generateDropDown(ArrayList<Integer> partTypeIds, ArrayList<Integer> partIds,
            ArrayList<Integer> revIds) {

        String ss = "";
        for (int i = 0; i < partIds.size(); i++) {
            String a = String.format("%03d", partTypeIds.get(i));
            String b = String.format("%05d", partIds.get(i));
            String c = String.format("%02d", revIds.get(i));

            ss = ss + "<option value=" + a + "-" + b + "-" + c + ">" + a + "-" + b + "-" + c + "</option>\n";
        }

        return ss;

    }

}
