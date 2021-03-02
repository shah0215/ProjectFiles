package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.team23.prototype1.dao.SerialNumberDao;
import com.team23.prototype1.model.SerialNumberModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class SerialNumberController {

    int snId = -1; // To store current PK of the row to be edited
    int INDEX = -1; // To store the current index

    /**
     * 
     * @return Dashboard with populated information
     * @throws IOException
     */
    @RequestMapping("serialNumberTable")
    public ModelAndView serialNumberHome() throws IOException {

        ModelAndView mv = new ModelAndView("SerialNumber");

        mv.addObject("action", "submitSerialNumber");
        mv.addObject("button", "ADD");
        SerialNumberDao dbInstance = new SerialNumberDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplierLotNumber", generateDropDownSupplierLotNumbers(dbInstance.supplierLotNumber()));

        mv.addObject("tableData", writeDashboard(dbInstance.serialNumberList));

        return mv;
    }

    /**
     * 
     * @return Sorted Dashboard wih newest record on top
     * @throws IOException
     */
    @RequestMapping("newestSn")
    public ModelAndView newestBom() throws IOException {
        ModelAndView mv = new ModelAndView("SerialNumber");

        mv.addObject("action", "submitSerialNumber");
        mv.addObject("button", "ADD");
        SerialNumberDao dbInstance = new SerialNumberDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplierLotNumber", generateDropDownSupplierLotNumbers(dbInstance.supplierLotNumber()));

        mv.addObject("tableData", writeDashboard(dbInstance.sortByNewest()));

        return mv;
    }

    /**
     * 
     * @return Sorted Dashboard wih oldest record on top
     * @throws IOException
     */
    @RequestMapping("oldestSn")
    public ModelAndView oldestBom() throws IOException {
        ModelAndView mv = new ModelAndView("SerialNumber");

        mv.addObject("action", "submitSerialNumber");
        mv.addObject("button", "ADD");
        SerialNumberDao dbInstance = new SerialNumberDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplierLotNumber", generateDropDownSupplierLotNumbers(dbInstance.supplierLotNumber()));

        mv.addObject("tableData", writeDashboard(dbInstance.sortByOldest()));

        return mv;
    }

    /**
     * Adding new Serial number storing the following data to database by subbmiting
     * it to Dao
     * 
     * 
     * @param partNumber
     * @param revId
     * @param dateReceived
     * @param supplierLotNumber
     * @param supplierSerialNumber
     * @param status
     * @param location
     * @param customer
     * @param testData
     * @param comments
     * 
     * 
     * @return Updated Dashboard
     * 
     * 
     * @throws IOException
     */
    @RequestMapping("submitSerialNumber")
    public ModelAndView addSerial(@RequestParam("partNumber") String partNumber, @RequestParam("revId") String revId,
            @RequestParam("dateReceived") String dateReceived,
            @RequestParam("supplierLotNumber") String supplierLotNumber,
            @RequestParam("supplierSerialNumber") String supplierSerialNumber, @RequestParam("status") String status,
            @RequestParam("location") String location, @RequestParam("customer") String customer,
            @RequestParam("testData") String testData, @RequestParam("comments") String comments) throws IOException {

        SerialNumberModel sn = new SerialNumberModel();

        if (supplierSerialNumber == null) {
            supplierSerialNumber = "";

        } else if (location == null) {
            location = "";
        } else if (customer == null) {
            customer = "";
        } else if (testData == null) {
            testData = "";
        } else if (comments == null) {
            comments = "";
        }

        sn.setPartNumber(partNumber);
        sn.setRevId(revId);
        sn.setDateReceived(dateReceived);
        sn.setSupplierLotNumber(supplierLotNumber);
        sn.setSupplierSerialNumber(supplierSerialNumber);
        sn.setStatus(status);
        sn.setLocation(location);
        sn.setCustomer(customer);
        sn.setTestData(testData);
        sn.setComments(comments);

        sn.setSerialNumber(SerialNumberDao.getPartCodes(partNumber));

        SerialNumberDao.addData(sn);

        return serialNumberHome();
    }

    @RequestMapping("deleteSn")
    public ModelAndView deleteSn(@RequestParam("id") int id, @RequestParam("index") int index) throws IOException {

        SerialNumberDao.deleteById(id);

        return serialNumberHome();
    }

    /**
     * 
     * @param id
     * @param index
     * 
     * @return prefilled form fields ready to be updated by the user
     * 
     * @throws IOException
     */
    @RequestMapping("editSn")
    public ModelAndView editSn(@RequestParam("id") int id, @RequestParam("index") int index) throws IOException {

        snId = id;
        INDEX = index;

        ModelAndView mv = new ModelAndView("SerialNumber");

        mv.addObject("action", "updateSn");
        mv.addObject("button", "UPDATE");
        SerialNumberDao dbInstance = new SerialNumberDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplierLotNumber", generateDropDownSupplierLotNumbers(dbInstance.supplierLotNumber()));

        mv.addObject("obj", dbInstance.serialNumberList.get(index));

        mv.addObject("tableData", writeDashboard(dbInstance.serialNumberList));

        return mv;
    }

    /**
     * Submitting the updated information to the Database
     * 
     * @param partNumber
     * @param revId
     * @param dateReceived
     * @param supplierLotNumber
     * @param supplierSerialNumber
     * @param status
     * @param location
     * @param customer
     * @param testData
     * @param comments
     * @return
     * @throws IOException
     */
    @RequestMapping("updateSn")
    public ModelAndView updateSn(@RequestParam("partNumber") String partNumber, @RequestParam("revId") String revId,
            @RequestParam("dateReceived") String dateReceived,
            @RequestParam("supplierLotNumber") String supplierLotNumber,
            @RequestParam("supplierSerialNumber") String supplierSerialNumber, @RequestParam("status") String status,
            @RequestParam("location") String location, @RequestParam("customer") String customer,
            @RequestParam("testData") String testData, @RequestParam("comments") String comments) throws IOException {

        SerialNumberModel sn = new SerialNumberModel();

        if (supplierSerialNumber == null) {
            supplierSerialNumber = "";

        } else if (location == null) {
            location = "";
        } else if (customer == null) {
            customer = "";
        } else if (testData == null) {
            testData = "";
        } else if (comments == null) {
            comments = "";
        }

        sn.setPartNumber(partNumber);
        sn.setRevId(revId);
        sn.setDateReceived(dateReceived);
        sn.setSupplierLotNumber(supplierLotNumber);
        sn.setSupplierSerialNumber(supplierSerialNumber);
        sn.setStatus(status);
        sn.setLocation(location);
        sn.setCustomer(customer);
        sn.setTestData(testData);
        sn.setComments(comments);

        sn.setSerialNumber(SerialNumberDao.getPartCodes(partNumber));

        SerialNumberDao.updateById(snId, sn);

        return serialNumberHome();
    }

    /**
     * 
     * @param list of SerialNumberModel objects carrying data from database
     * @return The Html code to populate the dashboard with the data
     * @throws IOException
     */
    public String writeDashboard(ArrayList<SerialNumberModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            ss = ss + ("<tr><td>" + list.get(i).getPartNumber() +

                    "</td>"

                    + "<td>" + list.get(i).getRevId() + "</td>" + "<td>" + list.get(i).getSerialNumber() + "</td>"
                    + "<td>" + list.get(i).getDateReceived() + "</td>" + "<td>" + list.get(i).getSupplierLotNumber()
                    + "</td>" + "<td>" + list.get(i).getSupplierSerialNumber() + "</td>" + "<td>"
                    + list.get(i).getStatus() + "</td>" + "<td>" + list.get(i).getLocation() + "</td>" + "<td>"
                    + list.get(i).getCustomer() + "</td>" + "<td>" + list.get(i).getTestData() + "</td>" + "<td>"
                    + list.get(i).getComments() + "</td>" + "<td><a href=\"editSn?id=" + list.get(i).getId() + "&index="
                    + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"deleteSn?id=" + list.get(i).getId()
                    + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * generating drop down menu = XXX-YYYYY in Serial Number table
     * 
     * @param partTypeIds
     * @param partIds
     * @return Html code for dropDown menu
     */
    public String generateDropDownPartNumber(ArrayList<Integer> partTypeIds, ArrayList<Integer> partIds) {

        String ss = "";
        for (int i = 0; i < partIds.size(); i++) {
            String a = String.format("%03d", partTypeIds.get(i));
            String b = String.format("%05d", partIds.get(i));

            ss = ss + "<option value=" + a + "-" + b + ">" + a + "-" + b + "</option>\n";
        }

        return ss;

    }

    /**
     * 
     * @param revIds = List of revision Ids
     * @return html code to genrate DropDown menu of REvision IDs in UI
     */
    public String generateDropDownRevIds(ArrayList<Integer> revIds) {

        String ss = "";
        for (int i = 0; i < revIds.size(); i++) {

            String a = String.format("%02d", revIds.get(i));

            ss = ss + "<option value=" + a + ">" + a + "</option>\n";
        }

        return ss;

    }

    /**
     * 
     * @param supplierLotNumber = list of supplier lot numbers to generate dropdown
     * @return Html code to generate dropdown of supplier lot number
     */
    public String generateDropDownSupplierLotNumbers(ArrayList<String> supplierLotNumber) {

        String ss = "";
        for (int i = 0; i < supplierLotNumber.size(); i++) {

            ss = ss + "<option value=" + supplierLotNumber.get(i) + ">" + supplierLotNumber.get(i) + "</option>\n";
        }

        return ss;

    }

}
