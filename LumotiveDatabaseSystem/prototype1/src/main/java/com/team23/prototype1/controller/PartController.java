package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team23.prototype1.dao.PartDao;
import com.team23.prototype1.model.PartModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class PartController {

    String id = ""; // To store the Id of the row to be edited
    int INDEX = -1; // To store the index from the PartData list of the row to be edited

    /**
     * 
     * @return Dashboard of PartTable
     * @throws IOException
     */
    @RequestMapping("partTable")
    public ModelAndView partTable() throws IOException {
        PartDao dbInstance = new PartDao();
        ModelAndView mv = new ModelAndView("partTable");
        mv.addObject("action", "addNewPart");
        mv.addObject("button", "ADD");
        mv.addObject("tableData", writeDashboard(dbInstance.PartData));
        mv.addObject("dropDown", generateDropDown(dbInstance.partIds()));

        return mv;
    }

    /**
     * Adding new Part Information the below are the parameters from the webform
     * 
     * @param partTypeId
     * @param revID
     * @param partDescription
     * @param partCode
     * @param partFolderLink
     * @param inspectionDoc
     * @param assemblyTestPlan
     * @param cstF1
     * @param cstF2
     * @param cstF3
     * @param cstF4
     * @param cstF5
     * 
     * 
     * @return The dashboard after adding a new part information
     * @throws IOException
     */
    @RequestMapping("addNewPart")
    public ModelAndView addNewPart(@RequestParam("partTypeId") int partTypeId, @RequestParam("revId") int revID,
            @RequestParam("description") String partDescription, @RequestParam("partCode") String partCode,
            @RequestParam("folderLink") String partFolderLink, @RequestParam("inspectionDocument") String inspectionDoc,
            @RequestParam("assemblyTestPlan") String assemblyTestPlan, @RequestParam("field1") String cstF1,
            @RequestParam("field2") String cstF2, @RequestParam("field3") String cstF3,
            @RequestParam("field4") String cstF4, @RequestParam("field5") String cstF5) throws IOException {

        PartModel object = new PartModel();

        object.setPartTypeId(partTypeId);
        object.setRevId(revID);
        object.setPartDescription(partDescription);
        object.setPartCode(partCode);
        object.setPartFolderLink(partFolderLink);
        object.setInspectionDocument(inspectionDoc);
        object.setAssemblyTestPlan(assemblyTestPlan);
        object.setCustomField1(cstF1);
        object.setCustomField2(cstF2);
        object.setCustomField3(cstF3);
        object.setCustomField4(cstF4);
        object.setCustomField5(cstF5);

        PartDao.addData(object);

        return partTable();

    }

    /**
     * 
     * @return Dashboard with the sorted table with newest on the top
     * @throws Throwable
     */
    @RequestMapping("newestPart")
    public ModelAndView newestRecords() throws Throwable {

        PartDao.sortByNewest();

        ModelAndView mv = new ModelAndView("partTable");
        mv.addObject("action", "addNewPart");
        mv.addObject("button", "ADD");
        mv.addObject("tableData", writeDashboard(PartDao.PartData));
        mv.addObject("dropDown", generateDropDown(PartDao.partIds()));

        return mv;

    }

    /**
     * 
     * @return Dashboard with the oldest parts on the top
     * @throws Throwable
     */
    @RequestMapping("oldestPart")
    public ModelAndView oldestRecords() throws Throwable {

        PartDao.sortByOldest();

        ModelAndView mv = new ModelAndView("partTable");
        mv.addObject("action", "addNewPart");
        mv.addObject("button", "ADD");
        mv.addObject("tableData", writeDashboard(PartDao.PartData));
        mv.addObject("dropDown", generateDropDown(PartDao.partIds()));
        return mv;

    }

    /**
     * 
     * @param partId
     * @param index
     * 
     * @return Dashboard after deleting the row
     * 
     * @throws IOException
     */
    @RequestMapping("deletePart")
    public ModelAndView delete(@RequestParam("id") String partId, @RequestParam("index") int index) throws IOException {

        PartDao.deleteRowbyPartID(partId);
        PartDao.PartData.remove(index);

        return partTable();
    }

    /**
     * 
     * @param partId
     * @param index
     * @return dasboard with filled information in the forms of the selected row
     * @throws IOException
     */
    @RequestMapping("editPart")
    public ModelAndView edit(@RequestParam("id") String partId, @RequestParam("index") int index) throws IOException {

        ModelAndView mv = new ModelAndView("partTable");
        mv.addObject("action", "updatePart");
        mv.addObject("button", "UPDATE");
        mv.addObject("obj", PartDao.PartData.get(index));

        id = partId; // Storing current part Id
        INDEX = index; // storing the current index

        mv.addObject("tableData", writeDashboard(PartDao.PartData));
        mv.addObject("dropDown", generateDropDown(PartDao.partIds()));

        return mv;
    }

    /**
     * 
     * Passing the updated infromation to the Database
     * 
     * 
     * @param partTypeId
     * @param revID
     * @param partDescription
     * @param partCode
     * @param partFolderLink
     * @param inspectionDoc
     * @param assemblyTestPlan
     * @param cstF1
     * @param cstF2
     * @param cstF3
     * @param cstF4
     * @param cstF5
     * @return
     * @throws IOException
     */
    @RequestMapping("updatePart")
    public ModelAndView update(@RequestParam("partTypeId") int partTypeId, @RequestParam("revId") int revID,
            @RequestParam("description") String partDescription, @RequestParam("partCode") String partCode,
            @RequestParam("folderLink") String partFolderLink, @RequestParam("inspectionDocument") String inspectionDoc,
            @RequestParam("assemblyTestPlan") String assemblyTestPlan, @RequestParam("field1") String cstF1,
            @RequestParam("field2") String cstF2, @RequestParam("field3") String cstF3,
            @RequestParam("field4") String cstF4, @RequestParam("field5") String cstF5) throws IOException {

        PartModel object = new PartModel();

        object.setPartTypeId(partTypeId);
        object.setRevId(revID);
        object.setPartDescription(partDescription);
        object.setPartCode(partCode);
        object.setPartFolderLink(partFolderLink);
        object.setInspectionDocument(inspectionDoc);
        object.setAssemblyTestPlan(assemblyTestPlan);
        object.setCustomField1(cstF1);
        object.setCustomField2(cstF2);
        object.setCustomField3(cstF3);
        object.setCustomField4(cstF4);
        object.setCustomField5(cstF5);

        PartDao dbInstance = new PartDao();

        dbInstance.editRowByPartID(id, object);

        return partTable();

    }

    /**
     * 
     * @param list
     * @return Generated HTML code to display database tables with all the filled
     *         infromations
     * @throws IOException
     */
    public String writeDashboard(ArrayList<PartModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            String partID = String.format("%05d", list.get(i).getPartId());
            String partTypeId = String.format("%03d", list.get(i).getPartTypeId());
            String revID = String.format("%02d", list.get(i).getRevId());

            ss = ss + ("<tr><td>" + partID + "</td><td>" + partTypeId + "</td><td>" + revID + "</td><td>"
                    + list.get(i).getPartDescription() + "</td><td>" + list.get(i).getPartCode() + "</td>" + "" + "<td>"
                    + list.get(i).getPartFolderLink() + "</td><td>" + list.get(i).getInspectionDocument() + "</td><td>"
                    + list.get(i).getAssemblyTestPlan() + "</td><td>" + list.get(i).getCustomField1() + "</td><td>"
                    + list.get(i).getCustomField2() + "</td><td>" + list.get(i).getCustomField3() + "</td><td>"
                    + list.get(i).getCustomField4() + "</td><td>" + list.get(i).getCustomField5() + "</td>"
                    + "<td><a href=\"editPart?id=" + list.get(i).getPartId() + "&index=" + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"deletePart?id="
                    + list.get(i).getPartId() + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * 
     * @param partIds
     * @return Generated code for DropDown of PartIds created in PartType table
     */
    public String generateDropDown(ArrayList<Integer> partIds) {

        String ss = "";
        for (int i = 0; i < partIds.size(); i++) {

            ss = ss + "<option value=" + partIds.get(i) + ">" + partIds.get(i) + "</option>\n";
        }

        return ss;

    }

}
