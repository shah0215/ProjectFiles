package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.team23.prototype1.dao.SnBulkDao;
import com.team23.prototype1.model.SnBulkModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class SnBulkController {

    int bulkId = -1;// To store the current Primary key of the selected row to be edited

    /**
     * 
     * @return Dashboard with data from database
     * @throws IOException
     */
    @RequestMapping("snBulkAssignTable")
    public ModelAndView snBulkHome() throws IOException {

        ModelAndView mv = new ModelAndView("SNBulkAssign");
        mv.addObject("action", "submitBulk");
        mv.addObject("button", "ADD");
        SnBulkDao dbInstance = new SnBulkDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));
        mv.addObject("dropDownSupplierPn", generateDropDownSupplierPns(dbInstance.supplierPns()));

        mv.addObject("tableData", writeDashboard(dbInstance.snBulkData));

        return mv;
    }

    /**
     * 
     * @return sorted Dashboard with latest record on top
     * @throws IOException
     */
    @RequestMapping("newestBulk")
    public ModelAndView newestBom() throws IOException {

        ModelAndView mv = new ModelAndView("SNBulkAssign");
        mv.addObject("action", "submitBulk");
        mv.addObject("button", "ADD");
        SnBulkDao dbInstance = new SnBulkDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));
        mv.addObject("dropDownSupplierPn", generateDropDownSupplierPns(dbInstance.supplierPns()));

        mv.addObject("tableData", writeDashboard(dbInstance.sortByNewest()));

        return mv;
    }

    /**
     * 
     * @return sorted Dashboard with oldest record on top
     * @throws IOException
     */
    @RequestMapping("oldestBulk")
    public ModelAndView oldestBom() throws IOException {
        ModelAndView mv = new ModelAndView("SNBulkAssign");
        mv.addObject("action", "submitBulk");
        mv.addObject("button", "ADD");
        SnBulkDao dbInstance = new SnBulkDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));
        mv.addObject("dropDownSupplierPn", generateDropDownSupplierPns(dbInstance.supplierPns()));

        mv.addObject("tableData", writeDashboard(dbInstance.sortByOldest()));

        return mv;
    }

    /**
     * submiting the new data to database having following dataset
     * 
     * 
     * @param partNumber
     * @param revId
     * @param dateReceived
     * @param quantityReceived
     * @param supplier
     * @param supplierPn
     * @param supplierLotNumber
     * @param comments
     * 
     * @return UPDATED DASHBOARD WITH NEW RECORD
     * 
     * 
     * @throws IOException
     */
    @RequestMapping("submitBulk")
    public ModelAndView addBulk(@RequestParam("partNumber") String partNumber, @RequestParam("revId") String revId,
            @RequestParam("dateReceived") String dateReceived,
            @RequestParam("quantityReceived") String quantityReceived, @RequestParam("supplier") String supplier,
            @RequestParam("supplierPn") String supplierPn, @RequestParam("supplierLotNumber") String supplierLotNumber,
            @RequestParam("comments") String comments) throws IOException {

        if (supplierLotNumber == null) {

            supplierLotNumber = "";
        } else if (quantityReceived == null) {

            quantityReceived = "0";
        } else if (comments == null) {

            comments = "";

        }

        SnBulkModel bulkData = new SnBulkModel();

        bulkData.setPartNumber(partNumber);
        bulkData.setRevId(revId);
        bulkData.setDateReceived(dateReceived);
        bulkData.setQuantityReceived(quantityReceived);
        bulkData.setSupplier(supplier);
        bulkData.setSupplierPn(supplierPn);
        bulkData.setSupplierLotNumber(supplierLotNumber);
        bulkData.setComments(comments);

        SnBulkDao.addData(bulkData);

        return snBulkHome();
    }

    /**
     * deleting row by PK= id
     * 
     * @param id
     * @param index
     * @return Dashboard after deleting the row
     * @throws IOException
     */
    @RequestMapping("deleteBulk")
    public ModelAndView deleteBulk(@RequestParam("id") int id, @RequestParam("index") int index) throws IOException {

        SnBulkDao.deleteById(id);

        return snBulkHome();
    }

    /**
     * 
     * 
     * 
     * @param id
     * @param index
     * @return prefilled infromation in the form fields with the selected row ready
     *         to be updated
     * @throws IOException
     */
    @RequestMapping("editBulk")
    public ModelAndView editBulk(@RequestParam("id") int id, @RequestParam("index") int index) throws IOException {
        bulkId = id;

        ModelAndView mv = new ModelAndView("SNBulkAssign");
        mv.addObject("action", "updateBulk");
        mv.addObject("button", "UPDATE");
        SnBulkDao dbInstance = new SnBulkDao();
        mv.addObject("dropDownPartNumber", generateDropDownPartNumber(dbInstance.partTypeIds(), dbInstance.partIds()));
        mv.addObject("dropDownRevId", generateDropDownRevIds(dbInstance.revIds()));
        mv.addObject("dropDownSupplier", generateDropDownSupplier(dbInstance.suppliers()));
        mv.addObject("dropDownSupplierPn", generateDropDownSupplierPns(dbInstance.supplierPns()));

        mv.addObject("tableData", writeDashboard(dbInstance.snBulkData));

        mv.addObject("obj", SnBulkDao.snBulkData.get(index));

        return mv;
    }

    /**
     * Submitting the updated information to the database
     * 
     * 
     * @param partNumber
     * @param revId
     * @param dateReceived
     * @param quantityReceived
     * @param supplier
     * @param supplierPn
     * @param supplierLotNumber
     * @param comments
     * 
     * @return Updated dashboard
     * 
     * 
     * @throws IOException
     */
    @RequestMapping("updateBulk")
    public ModelAndView updateBulk(@RequestParam("partNumber") String partNumber, @RequestParam("revId") String revId,
            @RequestParam("dateReceived") String dateReceived,
            @RequestParam("quantityReceived") String quantityReceived, @RequestParam("supplier") String supplier,
            @RequestParam("supplierPn") String supplierPn, @RequestParam("supplierLotNumber") String supplierLotNumber,
            @RequestParam("comments") String comments) throws IOException {

        if (supplierLotNumber == null) {

            supplierLotNumber = "";
        } else if (quantityReceived == null) {

            quantityReceived = "0";
        } else if (comments == null) {

            comments = "";

        }

        SnBulkModel bulkData = new SnBulkModel();

        bulkData.setPartNumber(partNumber);
        bulkData.setRevId(revId);
        bulkData.setDateReceived(dateReceived);
        bulkData.setQuantityReceived(quantityReceived);
        bulkData.setSupplier(supplier);
        bulkData.setSupplierPn(supplierPn);
        bulkData.setSupplierLotNumber(supplierLotNumber);
        bulkData.setComments(comments);

        SnBulkDao.updateById(bulkId, bulkData);

        return snBulkHome();
    }

    /**
     * 
     * @param list of SnBulkModel objects carrying the data from SNBULK table from
     *             database
     * 
     * @return Html code to generate html tables to view information in UI
     * 
     * 
     * @throws IOException
     */
    public String writeDashboard(ArrayList<SnBulkModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            ss = ss + ("<tr><td>" + list.get(i).getPartNumber() +

                    "</td>"

                    + "<td>" + list.get(i).getRevId() + "</td><td>" + list.get(i).getDateReceived() + "</td>" + "<td>"
                    + list.get(i).getQuantityReceived() + "</td>" + "<td>" + list.get(i).getSupplier() + "</td>"
                    + "<td>" + list.get(i).getSupplierPn() + "</td>" + "<td>" + list.get(i).getSupplierLotNumber()
                    + "</td>" + "<td>" + list.get(i).getComments() + "</td>" + "<td><a href=\"editBulk?id="
                    + list.get(i).getId() + "&index=" + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"deleteBulk?id=" + list.get(i).getId()
                    + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * genrating dropdown menu for part number = XXX-YYYYY
     * 
     * @param partTypeIds
     * @param partIds
     * @return HTML code to generate the dropdown for partNumber
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
     * generating dropdown for revision ID XX
     * 
     * @param revIds
     * @return
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
     * generating dropdown for suppliers
     * 
     * @param supplier
     * @return
     */
    public String generateDropDownSupplier(ArrayList<String> supplier) {

        String ss = "";
        for (int i = 0; i < supplier.size(); i++) {

            ss = ss + "<option value=" + supplier.get(i) + ">" + supplier.get(i) + "</option>\n";
        }

        return ss;

    }

    /**
     * generating dropdown for supplier Pns
     * 
     * @param supplierPns
     * @return
     */
    public String generateDropDownSupplierPns(ArrayList<String> supplierPns) {

        String ss = "";
        for (int i = 0; i < supplierPns.size(); i++) {

            ss = ss + "<option value=" + supplierPns.get(i) + ">" + supplierPns.get(i) + "</option>\n";
        }

        return ss;

    }

}
