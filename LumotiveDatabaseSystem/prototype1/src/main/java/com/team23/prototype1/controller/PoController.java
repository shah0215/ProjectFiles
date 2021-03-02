package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.team23.prototype1.dao.PoDao;
import com.team23.prototype1.model.PoModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class PoController {

    int poId = -1; // storing the current PO Primary key to edit the data
    int INDEX = -1;// storing current index of PoData list

    /**
     * 
     * @return Dashboard with tables
     * @throws IOException
     */
    @RequestMapping("poTable")
    public ModelAndView poHome() throws IOException {

        ModelAndView mv = new ModelAndView("Potable");

        mv.addObject("action", "submitPo");
        mv.addObject("button", "ADD");
        PoDao dbInstance = new PoDao();
        mv.addObject("tableData", writeDashboard(dbInstance.poData));
        mv.addObject("dropDownPartNumber",
                generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("dropDownQuoteId", generateDropDownQuoteId(dbInstance.quoteIds()));
        mv.addObject("dropDownOrderQuantity", generateDropDownOrderQuantity(dbInstance.orderQuantities()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));

        return mv;
    }

    /**
     * Adding new PO to database
     * 
     * @param partNumber
     * @param supplier
     * @param quoteId
     * @param poDate
     * @param orderQuantity
     * @param status
     * @param comments
     * @return
     * @throws IOException
     */
    @RequestMapping("submitPo")
    public ModelAndView addPo(@RequestParam("partNumber") String partNumber, @RequestParam("supplier") String supplier,
            @RequestParam("quoteId") String quoteId, @RequestParam("poDate") String poDate,
            @RequestParam("orderQuantity") String orderQuantity, @RequestParam("status") String status,
            @RequestParam("comments") String comments) throws IOException {

        if (comments == null) {
            comments = "";
        }

        PoModel poData = new PoModel();

        poData.setPartNumber(partNumber);
        poData.setComments(comments);
        poData.setOrderQuantity(orderQuantity);
        poData.setPodate(poDate);
        poData.setQuoteId(quoteId);
        poData.setStatus(status);
        poData.setSupplier(supplier);

        PoDao.addData(poData);

        return poHome();
    }

    /**
     * Deleting Po by id
     * 
     * @param id
     * @param index
     * @return Dashboard updated
     * @throws IOException
     */
    @RequestMapping("deletePo")
    public ModelAndView deletePo(@RequestParam("id") int id, @RequestParam("index") int index) throws IOException {

        PoDao.deleteById(id);

        return poHome();
    }

    /**
     * 
     * @param id
     * @param index
     * @return dashboard with prefilled forms with the select row to be edited
     * @throws IOException
     */
    @RequestMapping("editPo")
    public ModelAndView editPo(@RequestParam("id") int id, @RequestParam("index") int index) throws IOException {

        ModelAndView mv = new ModelAndView("Potable");

        mv.addObject("action", "updatePo");
        mv.addObject("button", "UPDATE");
        PoDao dbInstance = new PoDao();
        mv.addObject("tableData", writeDashboard(dbInstance.poData));
        mv.addObject("dropDownPartNumber",
                generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("dropDownQuoteId", generateDropDownQuoteId(dbInstance.quoteIds()));
        mv.addObject("dropDownOrderQuantity", generateDropDownOrderQuantity(dbInstance.orderQuantities()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));
        mv.addObject("obj", dbInstance.poData.get(index));

        poId = id;
        INDEX = index;

        return mv;
    }

    /**
     * Submitting the Updated Information to Dao
     * 
     * 
     * @param partNumber
     * @param supplier
     * @param quoteId
     * @param poDate
     * @param orderQuantity
     * @param status
     * @param comments
     * @return
     * @throws IOException
     */
    @RequestMapping("updatePo")
    public ModelAndView updatePo(@RequestParam("partNumber") String partNumber,
            @RequestParam("supplier") String supplier, @RequestParam("quoteId") String quoteId,
            @RequestParam("poDate") String poDate, @RequestParam("orderQuantity") String orderQuantity,
            @RequestParam("status") String status, @RequestParam("comments") String comments) throws IOException {

        if (comments == null) {
            comments = "";
        }

        PoModel poData = new PoModel();

        poData.setPartNumber(partNumber);
        poData.setComments(comments);
        poData.setOrderQuantity(orderQuantity);
        poData.setPodate(poDate);
        poData.setQuoteId(quoteId);
        poData.setStatus(status);
        poData.setSupplier(supplier);

        PoDao.updateById(poId, poData);

        return poHome();

    }

    /**
     * 
     * @return The sorted Po with newest record on the top
     * @throws IOException
     */
    @RequestMapping("newestPo")
    public ModelAndView newestBom() throws IOException {
        ModelAndView mv = new ModelAndView("Potable");

        mv.addObject("action", "submitPo");
        mv.addObject("button", "ADD");
        PoDao dbInstance = new PoDao();
        mv.addObject("tableData", writeDashboard(dbInstance.sortByNewest()));
        mv.addObject("dropDownPartNumber",
                generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("dropDownQuoteId", generateDropDownQuoteId(dbInstance.quoteIds()));
        mv.addObject("dropDownOrderQuantity", generateDropDownOrderQuantity(dbInstance.orderQuantities()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));

        return mv;
    }

    /**
     * 
     * @return The sorted Po with oldest record on the top
     * @throws IOException
     */
    @RequestMapping("oldestPo")
    public ModelAndView oldestBom() throws IOException {
        ModelAndView mv = new ModelAndView("Potable");

        mv.addObject("action", "submitPo");
        mv.addObject("button", "ADD");
        PoDao dbInstance = new PoDao();
        mv.addObject("tableData", writeDashboard(dbInstance.sortByOldest()));
        mv.addObject("dropDownPartNumber",
                generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("dropDownQuoteId", generateDropDownQuoteId(dbInstance.quoteIds()));
        mv.addObject("dropDownOrderQuantity", generateDropDownOrderQuantity(dbInstance.orderQuantities()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));

        return mv;
    }

    /**
     * 
     * @param list
     * @return Generated code of HTML to populate tables with the database data
     * @throws IOException
     */
    public String writeDashboard(ArrayList<PoModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            ss = ss + ("<tr><td>" + list.get(i).getPartNumber() +

                    "</td>"

                    + "<td>" + list.get(i).getSupplier() + "</td><td>" + list.get(i).getQuoteId() + "</td>" + "<td>"
                    + list.get(i).getPodate() + "</td>" + "<td>" + list.get(i).getOrderQuantity() + "</td>" + "<td>"
                    + list.get(i).getStatus() + "</td>" + "<td>" + list.get(i).getComments() + "</td>"
                    + "<td><a href=\"editPo?id=" + list.get(i).getId() + "&index=" + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"deletePo?id=" + list.get(i).getId()
                    + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * this generates the drop down menu of Part NUMBER with zerofills
     * 
     * @param partTypeIds
     * @param partIds
     * @param revIds
     * @return
     */
    public String generateDropDownPartNumber(ArrayList<Integer> partTypeIds, ArrayList<Integer> partIds,
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

    /**
     * 
     * @param supplier
     * @return Dropdown HTML code for SUPPLIER LIST
     */
    public String generateDropDownSupplier(ArrayList<String> supplier) {

        String ss = "";
        for (int i = 0; i < supplier.size(); i++) {

            ss = ss + "<option value=" + supplier.get(i) + ">" + supplier.get(i) + "</option>\n";
        }

        return ss;

    }

    /**
     * 
     * @param quoteId
     * @return GENERATED HTML CODE FOR QUOTE ID DROPDOWN
     */
    public String generateDropDownQuoteId(ArrayList<String> quoteId) {

        String ss = "";
        for (int i = 0; i < quoteId.size(); i++) {

            ss = ss + "<option value=" + quoteId.get(i) + ">" + quoteId.get(i) + "</option>\n";
        }

        return ss;

    }

    /**
     * 
     * @param orderQuantity
     * @return GENERATED HTML CODE FOR ORDER QUANTITY ID DROPDOWN
     */
    public String generateDropDownOrderQuantity(ArrayList<String> orderQuantity) {

        String ss = "";
        for (int i = 0; i < orderQuantity.size(); i++) {

            ss = ss + "<option value=" + orderQuantity.get(i) + ">" + orderQuantity.get(i) + "</option>\n";
        }

        return ss;

    }

}
