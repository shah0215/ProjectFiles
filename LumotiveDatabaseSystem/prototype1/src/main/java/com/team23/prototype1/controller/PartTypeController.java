package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team23.prototype1.dao.PartTypeDao;
import com.team23.prototype1.model.PartTypeModel;

/**
 * 
 * @author Himani
 *
 */
@org.springframework.stereotype.Controller
public class PartTypeController {

//this value is to be set to the current row's index.......
    int editIndex;
    String editPartID;

    public static String password; // Stores the passsword to the database

    /**
     * 
     * @return password entered by the user
     */
    public static String getPassword() {
        return password;
    }

    /**
     * 
     * @param password entered by user
     */
    public static void setPassword(String password) {
        PartTypeController.password = password;
    }

    /**
     * 
     * @return login page to database
     */
    @RequestMapping("loginToDb")
    public String login() {

        return "login";
    }

    /**
     * 
     * @param pass
     * @return Dashoard of First table
     * @throws IOException
     */
    @RequestMapping("logedIn")
    public ModelAndView login(@RequestParam("Pass") String pass) throws IOException {

        setPassword(pass);
        return gotoDashboard();
    }

    /**
     * 
     * @return Dashboard of PartType Table
     * @throws IOException
     */
    @RequestMapping("home")
    public ModelAndView home() throws IOException {

        ModelAndView mv = new ModelAndView();

        mv.addObject("Error", "");

        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * Submitting the new Part type to database having the following information
     * 
     * @param id          partType ID
     * @param Description Part Description
     * @param f1          Custom Field 1
     * @param f2          Custom Field 2
     * @param f3**
     * @param f4**
     * @param f5**
     * @return The partType table after adding new Row
     * @throws IOException
     */
    @RequestMapping("submit")
    public ModelAndView homepage(@RequestParam("id") int id, @RequestParam("description") String Description,
            @RequestParam("field1") String f1, @RequestParam("field2") String f2, @RequestParam("field3") String f3,
            @RequestParam("field4") String f4, @RequestParam("field5") String f5) throws IOException {
        PartTypeModel object = new PartTypeModel();


        object.setPartTypeId(id);
        try {
            object.setPartTypeDescription(Description);
        } catch (Exception e) {
            // TODO: handle exception
            object.setPartTypeDescription("");
        }
        try {
            object.setCustomField1(f1);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField1("");
        }
        try {
            object.setCustomField2(f2);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField2("");
        }
        try {
            object.setCustomField3(f3);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField3("");
        }
        try {
            object.setCustomField4(f4);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField4("");
        }
        try {
            object.setCustomField5(f5);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField5("");
        }

        PartTypeDao.addData(object);
        PartTypeDao.setData(object);
     

        ModelAndView mv = new ModelAndView();

        mv.addObject("Error", "");

        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @return Dashboard of PartType Table
     * @throws IOException
     */
    @RequestMapping("dashboard")
    public ModelAndView gotoDashboard() throws IOException {

        ModelAndView mv = new ModelAndView();
PartTypeDao dbInstance = new PartTypeDao();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @return Sorted tables with newest record on top
     * @throws Throwable
     */
    @RequestMapping("newest")
    public ModelAndView newestRecords() throws Throwable {

        PartTypeDao.sortByNewest();

        ModelAndView mv = new ModelAndView();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @return sorted table with oldest record on top
     * @throws Throwable
     */
    @RequestMapping("oldest")
    public ModelAndView oldestRecords() throws Throwable {

        PartTypeDao.sortByOldest();

        ModelAndView mv = new ModelAndView();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @return sorted table in Descending order with PartTypeIds
     * @throws Throwable
     */
    @RequestMapping("partTypeIdDesc")
    public ModelAndView sortedByPartIdDesc() throws Throwable {

        PartTypeDao.sortByDescID();

        ModelAndView mv = new ModelAndView();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @return sorted table in Ascending order with PartTypeIds
     * @throws Throwable
     */
    @RequestMapping("partTypeIdAsc")
    public ModelAndView sortedByPartIdAsc() throws Throwable {

        PartTypeDao.sortByAscID();

        ModelAndView mv = new ModelAndView();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @param part_id
     * @param index
     * @return Dashboard after deleting a row
     * @throws IOException
     */
    @RequestMapping("delete")
    public ModelAndView deleteRow(@RequestParam("id") String part_id, @RequestParam("index") int index)
            throws IOException {


        PartTypeDao.deleteRowbyPartID(part_id);
        PartTypeDao.data.remove(index);

        ModelAndView mv = new ModelAndView();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @param part_id
     * @param index
     * @return returns the forms with filled information of the selected row while
     *         editing
     * @throws IOException
     */
    @RequestMapping("edit")
    public ModelAndView editRow(@RequestParam("id") String part_id, @RequestParam("index") int index)
            throws IOException {


        ModelAndView mv = new ModelAndView();

        mv.addObject("id", PartTypeDao.data.get(index).getPartTypeId());
        mv.addObject("description", PartTypeDao.data.get(index).getPartTypeDescription());
        mv.addObject("f1", PartTypeDao.data.get(index).getCustomField1());
        mv.addObject("f2", PartTypeDao.data.get(index).getCustomField2());
        mv.addObject("f3", PartTypeDao.data.get(index).getCustomField3());
        mv.addObject("f4", PartTypeDao.data.get(index).getCustomField4());
        mv.addObject("f5", PartTypeDao.data.get(index).getCustomField5());
        editIndex = index;
        editPartID = part_id;
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("updatePart");

        return mv;

    }

    /**
     * 
     * Updated infromation stored and submitted to the Dao
     * 
     * 
     * @param id
     * @param Description
     * @param f1
     * @param f2
     * @param f3
     * @param f4
     * @param f5
     * @return
     * @throws IOException
     */
    @RequestMapping("update")
    public ModelAndView update(@RequestParam("id") int id, @RequestParam("description") String Description,
            @RequestParam("field1") String f1, @RequestParam("field2") String f2, @RequestParam("field3") String f3,
            @RequestParam("field4") String f4, @RequestParam("field5") String f5) throws IOException {
        PartTypeModel object = new PartTypeModel();


        object.setPartTypeId(id);
        try {
            object.setPartTypeDescription(Description);
        } catch (Exception e) {
            // TODO: handle exception
            object.setPartTypeDescription("");
        }
        try {
            object.setCustomField1(f1);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField1("");
        }
        try {
            object.setCustomField2(f2);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField2("");
        }
        try {
            object.setCustomField3(f3);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField3("");
        }
        try {
            object.setCustomField4(f4);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField4("");
        }
        try {
            object.setCustomField5(f5);
        } catch (Exception e) {
            // TODO: handle exception
            object.setCustomField5("");
        }

        // updating data in arraylist
        PartTypeDao.data.set(editIndex, object);
        // Updating in database
        PartTypeDao.editRowByPartID(editPartID, object);


        ModelAndView mv = new ModelAndView();
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        mv.setViewName("createPartType");

        return mv;

    }

    /**
     * 
     * @param list
     * @return Generated HTML code for the Rows from database to display in web
     *         Browser
     * @throws IOException
     */
    public static String writeDashboard(ArrayList<PartTypeModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            String partTypeId = String.format("%03d", list.get(i).getPartTypeId());

            ss = ss + ("<tr><td>" + partTypeId + "</td><td>" + list.get(i).getPartTypeDescription() + "</td><td>"
                    + list.get(i).getCustomField1() + "</td><td>" + list.get(i).getCustomField2() + "</td><td>"
                    + list.get(i).getCustomField3() + "</td><td>" + list.get(i).getCustomField4() + "</td><td>"
                    + list.get(i).getCustomField5() + "</td>" + "<td><a href=\"edit?id=" + list.get(i).getPartTypeId()
                    + "&index=" + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"delete?id="
                    + list.get(i).getPartTypeId() + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * This method is currently in no use this is for refrence for further
     * development that this way they can show the error messages to the User
     * Interface
     * 
     * 
     * @param error
     * @return Dashboard with error message if a duplicate part is added
     * @throws IOException
     */
    public static ModelAndView duplicatePartTypeEntry(String error) throws IOException {
        // TODO Auto-generated method stub
        ModelAndView mv = new ModelAndView();

        mv.addObject("Error", error);
        mv.addObject("tableData", writeDashboard(PartTypeDao.data));
        
        mv.setViewName("createPartType");

        return mv;

    }

}
