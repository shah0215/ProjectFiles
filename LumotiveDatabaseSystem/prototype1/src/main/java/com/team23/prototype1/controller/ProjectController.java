package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.team23.prototype1.dao.ProjectDao;
import com.team23.prototype1.model.ProjectModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class ProjectController {

    String id = ""; // stores the current id to be editted
    int INDEX = -1; // stores the index

    /**
     * 
     * @return DASHBOARD
     * @throws IOException
     */
    @RequestMapping("projectTable")
    public ModelAndView projectHome() throws IOException {

        ModelAndView mv = new ModelAndView("Project");

        ProjectDao dbInstance = new ProjectDao();
        mv.addObject("action", "submitProject");
        mv.addObject("button", "ADD");

        mv.addObject("tableData", writeDashboard(dbInstance.projectData));

        mv.addObject("associatedParts", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds()));

        return mv;
    }

    /**
     * 
     * Submitting new project infromation to the database
     * 
     * 
     * @param projectName
     * @param projectDescription
     * @param startDate
     * @param endDate
     * @param associatedParts
     * 
     * @return The dashboard after adding the new record
     * 
     * @throws IOException
     */
    @RequestMapping("submitProject")
    public ModelAndView addProject(@RequestParam("projectName") String projectName,
            @RequestParam("projectDescription") String projectDescription, @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate, @RequestParam("associatedParts") String associatedParts)
            throws IOException {

        ProjectModel project = new ProjectModel();

        project.setProjectId("");// no need to set while adding
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setAssociatedParts(associatedParts);

        ProjectDao.addData(project);

        return projectHome();
    }

    /**
     * deleting by Project ID Primary Key
     * 
     * 
     * @param projectId
     * @param index
     * @return
     * @throws IOException
     */
    @RequestMapping("deleteProject")
    public ModelAndView deleteProject(@RequestParam("id") String projectId, @RequestParam("index") String index)
            throws IOException {

        ProjectDao.deleteByProjectId(projectId);

        return projectHome();
    }

    /**
     * 
     * @param projectId
     * @param index
     * @return The Dashboard with the prefilled information in the forms which user
     *         selects to edit
     * @throws IOException
     */
    @RequestMapping("editProject")
    public ModelAndView editProject(@RequestParam("id") String projectId, @RequestParam("index") int index)
            throws IOException {

        id = projectId;
        INDEX = index;

        ModelAndView mv = new ModelAndView("Project");
        ProjectDao dbInstance = new ProjectDao();
        mv.addObject("tableData", writeDashboard(dbInstance.projectData));

        mv.addObject("associatedParts", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds()));

        mv.addObject("obj", ProjectDao.projectData.get(index));

        mv.addObject("action", "updateProject");
        mv.addObject("button", "UPDATE");

        return mv;
    }

    /**
     * Submitting the updated information to the database
     * 
     * @param projectName
     * @param projectDescription
     * @param startDate
     * @param endDate
     * @param associatedParts
     * 
     * @return The dashboard Updated
     * 
     * @throws IOException
     */
    @RequestMapping("updateProject")
    public ModelAndView updateProject(@RequestParam("projectName") String projectName,
            @RequestParam("projectDescription") String projectDescription, @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate, @RequestParam("associatedParts") String associatedParts)
            throws IOException {

        ProjectModel project = new ProjectModel();

        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setAssociatedParts(associatedParts);

        ProjectDao.editByProjectId(id, project);

        return projectHome();
    }

    /**
     * 
     * 
     * @return the Dashboard with sorted by newest record
     * @throws IOException
     */
    @RequestMapping("newestProject")
    public ModelAndView newestBom() throws IOException {
        ModelAndView mv = new ModelAndView("Project");

        ProjectDao dbInstance = new ProjectDao();
        mv.addObject("action", "submitProject");
        mv.addObject("button", "ADD");

        mv.addObject("tableData", writeDashboard(dbInstance.sortByNewest()));

        mv.addObject("associatedParts", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds()));

        return mv;
    }

    /**
     * 
     * @return The dashbaord with sorted by oldest record
     * @throws IOException
     */
    @RequestMapping("oldestProject")
    public ModelAndView oldestBom() throws IOException {
        ModelAndView mv = new ModelAndView("Project");

        ProjectDao dbInstance = new ProjectDao();
        mv.addObject("action", "submitProject");
        mv.addObject("button", "ADD");

        mv.addObject("tableData", writeDashboard(dbInstance.sortByOldest()));

        mv.addObject("associatedParts", generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds()));

        return mv;
    }

    /**
     * 
     * 
     * @param list of objects of ProjectModel carrying data from database to
     *             populate table
     * @return THE hTml code with the Table data from database
     * @throws IOException
     */
    public String writeDashboard(ArrayList<ProjectModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            String[] elements = list.get(i).getAssociatedParts().split(",");
            String associatedParts = "";
            for (int j = 0; j < elements.length; j++) {

                associatedParts = associatedParts + "<option>(" + (j + 1) + ") " + elements[j] + "</option>";
            }

            ss = ss + ("<tr><td>" + list.get(i).getProjectId() +

                    "</td>"

                    + "<td>" + list.get(i).getProjectName() + "</td><td>" + list.get(i).getProjectDescription()
                    + "</td>" + "<td>" + list.get(i).getStartDate() + "</td>" + "<td>" + list.get(i).getEndDate()
                    + "</td>" + "<td><select id=\"select\">" + associatedParts
                    + "</select></td><td><a href=\"editProject?id=" + list.get(i).getProjectId() + "&index="
                    + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"deleteProject?id="
                    + list.get(i).getProjectId() + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * this generates the drop down menu with zerofills
     * 
     * @param partTypeIds
     * @param partIds
     * @param revIds
     * @return
     */
    public String generateDropDown(ArrayList<Integer> partTypeIds, ArrayList<Integer> partIds) {

        String ss = "";
        for (int i = 0; i < partIds.size(); i++) {
            String a = String.format("%03d", partTypeIds.get(i));
            String b = String.format("%05d", partIds.get(i));

            ss = ss + "<option value=" + a + "-" + b + ">" + a + "-" + b + "</option>\n";
        }

        return ss;

    }

}
