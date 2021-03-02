package com.team23.prototype1.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.team23.prototype1.dao.QuoteDao;
import com.team23.prototype1.model.QNPL;
import com.team23.prototype1.model.QuoteModel;

/**
 * 
 * @author Himani
 *
 */
@Controller
public class QuoteController {

    String id = ""; // for storing the current Primary key in to be editted
    int INDEX = -1; // for Storing the current Index to be eddited

    /**
     * 
     * @return Dashboard with populated information from the database
     * @throws IOException
     */
    @RequestMapping("quoteTable")
    public ModelAndView quoteHome() throws IOException {

        ModelAndView mv = new ModelAndView("quote");
        QuoteDao dbInstance = new QuoteDao();

        mv.addObject("action", "submitQuote");
        mv.addObject("button", "ADD");
        mv.addObject("dropDownPartNumber",
                generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("tableData", writeDashboard(QuoteDao.quoteData));

        return mv;
    }

    /**
     * 
     * submitting the following information to database
     * 
     * 
     * 
     * @param partNumber
     * @param supplierName
     * @param quoteId
     * @param quoteLink
     * @param supplierLink
     * @param quoteDate
     * @param supplierPn
     * @param manufacturerPn
     * @param currency
     * @param quantity1
     * @param nre1
     * @param price1
     * @param leadTime1
     * @param quantity2
     * @param nre2
     * @param price2
     * @param leadTime2
     * @param quantity3
     * @param nre3
     * @param price3
     * @param leadTime3
     * @param quantity4
     * @param nre4
     * @param price4
     * @param leadTime4
     * @param quantity5
     * @param nre5
     * @param price5
     * @param leadTime5
     * @param quantity6
     * @param nre6
     * @param price6
     * @param leadTime6
     * @param quantity7
     * @param nre7
     * @param price7
     * @param leadTime7
     * @param quantity8
     * @param nre8
     * @param price8
     * @param leadTime8
     * @param quantity9
     * @param nre9
     * @param price9
     * @param leadTime9
     * @param quantity10
     * @param nre10
     * @param price10
     * @param leadTime10
     * 
     * 
     * @return Updated Dashboard
     * 
     * 
     * @throws IOException
     */
    @RequestMapping("submitQuote")
    public ModelAndView addQuote(@RequestParam("partNumber") String partNumber,
            @RequestParam("supplierName") String supplierName, @RequestParam("quoteId") String quoteId,
            @RequestParam("quoteLink") String quoteLink, @RequestParam("supplierLink") String supplierLink,
            @RequestParam("quoteDate") String quoteDate, @RequestParam("supplierPn") String supplierPn,
            @RequestParam("manufacturerPn") String manufacturerPn, @RequestParam("currency") String currency,

            @RequestParam("quantity1") String quantity1, @RequestParam("nre1") String nre1,
            @RequestParam("price1") String price1, @RequestParam("leadTime1") String leadTime1,

            @RequestParam("quantity2") String quantity2, @RequestParam("nre2") String nre2,
            @RequestParam("price2") String price2, @RequestParam("leadTime2") String leadTime2,

            @RequestParam("quantity3") String quantity3, @RequestParam("nre3") String nre3,
            @RequestParam("price3") String price3, @RequestParam("leadTime3") String leadTime3,

            @RequestParam("quantity4") String quantity4, @RequestParam("nre4") String nre4,
            @RequestParam("price4") String price4, @RequestParam("leadTime4") String leadTime4,

            @RequestParam("quantity5") String quantity5, @RequestParam("nre5") String nre5,
            @RequestParam("price5") String price5, @RequestParam("leadTime5") String leadTime5,

            @RequestParam("quantity6") String quantity6, @RequestParam("nre6") String nre6,
            @RequestParam("price6") String price6, @RequestParam("leadTime6") String leadTime6,

            @RequestParam("quantity7") String quantity7, @RequestParam("nre7") String nre7,
            @RequestParam("price7") String price7, @RequestParam("leadTime7") String leadTime7,

            @RequestParam("quantity8") String quantity8, @RequestParam("nre8") String nre8,
            @RequestParam("price8") String price8, @RequestParam("leadTime8") String leadTime8,

            @RequestParam("quantity9") String quantity9, @RequestParam("nre9") String nre9,
            @RequestParam("price9") String price9, @RequestParam("leadTime9") String leadTime9,

            @RequestParam("quantity10") String quantity10, @RequestParam("nre10") String nre10,
            @RequestParam("price10") String price10, @RequestParam("leadTime10") String leadTime10) throws IOException {

        QuoteModel quote = new QuoteModel();

        if (quoteId == null) {

            quoteId = "";

        } else if (quoteLink == null) {
            quoteLink = "";
        } else if (supplierLink == null) {
            supplierLink = "";
        } else if (quoteDate == null) {
            quoteDate = "";
        } else if (supplierPn == null) {
            supplierPn = "";
        } else if (manufacturerPn == null) {
            manufacturerPn = "";
        } else if (currency == null) {
            currency = "";
        } else if (quantity2 == null) {
            quantity2 = "";
        } else if (quantity3 == null) {
            quantity3 = "";
        } else if (quantity4 == null) {
            quantity4 = "";
        } else if (quantity5 == null) {
            quantity5 = "";
        } else if (quantity6 == null) {
            quantity6 = "";
        } else if (quantity7 == null) {
            quantity7 = "";
        } else if (quantity8 == null) {
            quantity8 = "";
        } else if (quantity9 == null) {
            quantity9 = "";
        } else if (quantity10 == null) {
            quantity10 = "";
        }

        else if (nre2 == null) {
            nre2 = "";
        } else if (nre3 == null) {
            nre3 = "";
        } else if (nre4 == null) {
            nre4 = "";
        } else if (nre5 == null) {
            nre5 = "";
        } else if (nre6 == null) {
            nre6 = "";
        } else if (nre7 == null) {
            nre7 = "";
        } else if (nre8 == null) {
            nre8 = "";
        } else if (nre9 == null) {
            nre9 = "";
        } else if (nre10 == null) {
            nre10 = "";
        }

        else if (price2 == null) {
            price2 = "";
        } else if (price3 == null) {
            price3 = "";
        } else if (price4 == null) {
            price4 = "";
        } else if (price5 == null) {
            price5 = "";
        } else if (price6 == null) {
            price6 = "";
        } else if (price7 == null) {
            price7 = "";
        } else if (price8 == null) {
            price8 = "";
        } else if (price9 == null) {
            price9 = "";
        } else if (price10 == null) {
            price10 = "";
        }

        else if (leadTime2 == null) {
            leadTime2 = "";
        } else if (leadTime3 == null) {
            leadTime3 = "";
        } else if (leadTime4 == null) {
            leadTime4 = "";
        } else if (leadTime5 == null) {
            leadTime5 = "";
        } else if (leadTime6 == null) {
            leadTime6 = "";
        } else if (leadTime7 == null) {
            leadTime7 = "";
        } else if (leadTime8 == null) {
            leadTime8 = "";
        } else if (leadTime9 == null) {
            leadTime9 = "";
        } else if (leadTime10 == null) {
            leadTime10 = "";
        }

        quote.setPartNumber(partNumber);
        quote.setSupplierName(supplierName);

        quote.setQuoteId(quoteId);
        quote.setQuoteLink(quoteLink);
        quote.setSupplierLink(supplierLink);
        quote.setQuoteDate(quoteDate);
        quote.setSupplierPn(supplierPn);
        quote.setManufacturerPn(manufacturerPn);
        quote.setCurrency(currency);

        /**
         * 
         * Submiting the dataset as Json Array to the database to avoid the creation of
         * 40 columns in the database
         * 
         */
        String qnplJson = "{\r\n" + "   \"quantity\": [\"" + quantity1 + "\",\"" + quantity2 + "\",\"" + quantity3
                + "\",\"" + quantity4 + "\",\"" + quantity5 + "\",\"" + quantity6 + "\",\"" + quantity7 + "\",\""
                + quantity8 + "\",\"" + quantity9 + "\",\"" + quantity10 + "\"],\r\n" + " \"nre\": [\"" + nre1 + "\",\""
                + nre2 + "\",\"" + nre3 + "\",\"" + nre4 + "\",\"" + nre5 + "\",\"" + nre6 + "\",\"" + nre7 + "\",\""
                + nre8 + "\",\"" + nre9 + "\",\"" + nre10 + "\"],\r\n" + " \"price\": [\"" + price1 + "\",\"" + price2
                + "\",\"" + price3 + "\",\"" + price4 + "\",\"" + price5 + "\",\"" + price6 + "\",\"" + price7 + "\",\""
                + price8 + "\",\"" + price9 + "\",\"" + price10 + "\"],\r\n" + " \"leadTime\" : [\"" + leadTime1
                + "\",\"" + leadTime2 + "\",\"" + leadTime3 + "\",\"" + leadTime4 + "\",\"" + leadTime5 + "\",\""
                + leadTime6 + "\",\"" + leadTime7 + "\",\"" + leadTime8 + "\",\"" + leadTime9 + "\",\"" + leadTime10
                + "\"]\r\n" + "}";

        quote.setQnpl(qnplJson);

        QuoteDao.addData(quote);

        return quoteHome();
    }

    /**
     * deletes quote row by Primary key= Supplier Name
     * 
     * @param supplierName
     * @param index
     * 
     * @return updated Dashboard
     * 
     * @throws IOException
     */
    @RequestMapping("deleteQuote")
    public ModelAndView deleteQuote(@RequestParam("supplierName") String supplierName, @RequestParam("index") int index)
            throws IOException {

        QuoteDao.deleteBySupplierName(supplierName);

        return quoteHome();
    }

    /**
     * 
     * @param supplierName =Primary Key
     * @param index
     * 
     * @return prefilled form values in the form fields ready to be editted by the
     *         user
     * 
     * @throws IOException
     */
    @RequestMapping("editQuote")
    public ModelAndView editQuote(@RequestParam("supplierName") String supplierName, @RequestParam("index") int index)
            throws IOException {
        QuoteDao dbInstance = new QuoteDao();

        id = supplierName;
        INDEX = index;

        ModelAndView mv = new ModelAndView("quote");
        mv.addObject("action", "updateQuote");
        mv.addObject("button", "UPDATE");

        mv.addObject("obj", QuoteDao.quoteData.get(index));

        Gson gson = new Gson();

        QNPL qnpl = gson.fromJson(QuoteDao.quoteData.get(index).getQnpl(), QNPL.class);

        mv.addObject("json", qnpl);

        mv.addObject("dropDownPartNumber",
                generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("tableData", writeDashboard(QuoteDao.quoteData));

        return mv;
    }

    /**
     * 
     * Submitting the updated values to Database
     * 
     * 
     * @param partNumber
     * @param supplierName
     * @param quoteId
     * @param quoteLink
     * @param supplierLink
     * @param quoteDate
     * @param supplierPn
     * @param manufacturerPn
     * @param currency
     * @param quantity1
     * @param nre1
     * @param price1
     * @param leadTime1
     * @param quantity2
     * @param nre2
     * @param price2
     * @param leadTime2
     * @param quantity3
     * @param nre3
     * @param price3
     * @param leadTime3
     * @param quantity4
     * @param nre4
     * @param price4
     * @param leadTime4
     * @param quantity5
     * @param nre5
     * @param price5
     * @param leadTime5
     * @param quantity6
     * @param nre6
     * @param price6
     * @param leadTime6
     * @param quantity7
     * @param nre7
     * @param price7
     * @param leadTime7
     * @param quantity8
     * @param nre8
     * @param price8
     * @param leadTime8
     * @param quantity9
     * @param nre9
     * @param price9
     * @param leadTime9
     * @param quantity10
     * @param nre10
     * @param price10
     * @param leadTime10
     * @return
     * @throws IOException
     */
    @RequestMapping("updateQuote")
    public ModelAndView updateQuote(@RequestParam("partNumber") String partNumber,
            @RequestParam("supplierName") String supplierName, @RequestParam("quoteId") String quoteId,
            @RequestParam("quoteLink") String quoteLink, @RequestParam("supplierLink") String supplierLink,
            @RequestParam("quoteDate") String quoteDate, @RequestParam("supplierPn") String supplierPn,
            @RequestParam("manufacturerPn") String manufacturerPn, @RequestParam("currency") String currency,

            @RequestParam("quantity1") String quantity1, @RequestParam("nre1") String nre1,
            @RequestParam("price1") String price1, @RequestParam("leadTime1") String leadTime1,

            @RequestParam("quantity2") String quantity2, @RequestParam("nre2") String nre2,
            @RequestParam("price2") String price2, @RequestParam("leadTime2") String leadTime2,

            @RequestParam("quantity3") String quantity3, @RequestParam("nre3") String nre3,
            @RequestParam("price3") String price3, @RequestParam("leadTime3") String leadTime3,

            @RequestParam("quantity4") String quantity4, @RequestParam("nre4") String nre4,
            @RequestParam("price4") String price4, @RequestParam("leadTime4") String leadTime4,

            @RequestParam("quantity5") String quantity5, @RequestParam("nre5") String nre5,
            @RequestParam("price5") String price5, @RequestParam("leadTime5") String leadTime5,

            @RequestParam("quantity6") String quantity6, @RequestParam("nre6") String nre6,
            @RequestParam("price6") String price6, @RequestParam("leadTime6") String leadTime6,

            @RequestParam("quantity7") String quantity7, @RequestParam("nre7") String nre7,
            @RequestParam("price7") String price7, @RequestParam("leadTime7") String leadTime7,

            @RequestParam("quantity8") String quantity8, @RequestParam("nre8") String nre8,
            @RequestParam("price8") String price8, @RequestParam("leadTime8") String leadTime8,

            @RequestParam("quantity9") String quantity9, @RequestParam("nre9") String nre9,
            @RequestParam("price9") String price9, @RequestParam("leadTime9") String leadTime9,

            @RequestParam("quantity10") String quantity10, @RequestParam("nre10") String nre10,
            @RequestParam("price10") String price10, @RequestParam("leadTime10") String leadTime10) throws IOException {

        QuoteModel quote = new QuoteModel();

        if (quoteId == null) {

            quoteId = "";

        } else if (quoteLink == null) {
            quoteLink = "";
        } else if (supplierLink == null) {
            supplierLink = "";
        } else if (quoteDate == null) {
            quoteDate = "";
        } else if (supplierPn == null) {
            supplierPn = "";
        } else if (manufacturerPn == null) {
            manufacturerPn = "";
        } else if (currency == null) {
            currency = "";
        } else if (quantity2 == null) {
            quantity2 = "";
        } else if (quantity3 == null) {
            quantity3 = "";
        } else if (quantity4 == null) {
            quantity4 = "";
        } else if (quantity5 == null) {
            quantity5 = "";
        } else if (quantity6 == null) {
            quantity6 = "";
        } else if (quantity7 == null) {
            quantity7 = "";
        } else if (quantity8 == null) {
            quantity8 = "";
        } else if (quantity9 == null) {
            quantity9 = "";
        } else if (quantity10 == null) {
            quantity10 = "";
        }

        else if (nre2 == null) {
            nre2 = "";
        } else if (nre3 == null) {
            nre3 = "";
        } else if (nre4 == null) {
            nre4 = "";
        } else if (nre5 == null) {
            nre5 = "";
        } else if (nre6 == null) {
            nre6 = "";
        } else if (nre7 == null) {
            nre7 = "";
        } else if (nre8 == null) {
            nre8 = "";
        } else if (nre9 == null) {
            nre9 = "";
        } else if (nre10 == null) {
            nre10 = "";
        }

        else if (price2 == null) {
            price2 = "";
        } else if (price3 == null) {
            price3 = "";
        } else if (price4 == null) {
            price4 = "";
        } else if (price5 == null) {
            price5 = "";
        } else if (price6 == null) {
            price6 = "";
        } else if (price7 == null) {
            price7 = "";
        } else if (price8 == null) {
            price8 = "";
        } else if (price9 == null) {
            price9 = "";
        } else if (price10 == null) {
            price10 = "";
        }

        else if (leadTime2 == null) {
            leadTime2 = "";
        } else if (leadTime3 == null) {
            leadTime3 = "";
        } else if (leadTime4 == null) {
            leadTime4 = "";
        } else if (leadTime5 == null) {
            leadTime5 = "";
        } else if (leadTime6 == null) {
            leadTime6 = "";
        } else if (leadTime7 == null) {
            leadTime7 = "";
        } else if (leadTime8 == null) {
            leadTime8 = "";
        } else if (leadTime9 == null) {
            leadTime9 = "";
        } else if (leadTime10 == null) {
            leadTime10 = "";
        }

        quote.setPartNumber(partNumber);
        quote.setSupplierName(supplierName);

        quote.setQuoteId(quoteId);
        quote.setQuoteLink(quoteLink);
        quote.setSupplierLink(supplierLink);
        quote.setQuoteDate(quoteDate);
        quote.setSupplierPn(supplierPn);
        quote.setManufacturerPn(manufacturerPn);
        quote.setCurrency(currency);

        String qnplJson = "{\r\n" + "   \"quantity\": [\"" + quantity1 + "\",\"" + quantity2 + "\",\"" + quantity3
                + "\",\"" + quantity4 + "\",\"" + quantity5 + "\",\"" + quantity6 + "\",\"" + quantity7 + "\",\""
                + quantity8 + "\",\"" + quantity9 + "\",\"" + quantity10 + "\"],\r\n" + " \"nre\": [\"" + nre1 + "\",\""
                + nre2 + "\",\"" + nre3 + "\",\"" + nre4 + "\",\"" + nre5 + "\",\"" + nre6 + "\",\"" + nre7 + "\",\""
                + nre8 + "\",\"" + nre9 + "\",\"" + nre10 + "\"],\r\n" + " \"price\": [\"" + price1 + "\",\"" + price2
                + "\",\"" + price3 + "\",\"" + price4 + "\",\"" + price5 + "\",\"" + price6 + "\",\"" + price7 + "\",\""
                + price8 + "\",\"" + price9 + "\",\"" + price10 + "\"],\r\n" + " \"leadTime\" : [\"" + leadTime1
                + "\",\"" + leadTime2 + "\",\"" + leadTime3 + "\",\"" + leadTime4 + "\",\"" + leadTime5 + "\",\""
                + leadTime6 + "\",\"" + leadTime7 + "\",\"" + leadTime8 + "\",\"" + leadTime9 + "\",\"" + leadTime10
                + "\"]\r\n" + "}";

        quote.setQnpl(qnplJson);

        QuoteDao.updateBySupplierName(id, quote);
        
     
        
        return quoteHome();

    }

    /**
     * 
     * @return Sorted Dashboard by newest record
     * @throws IOException
     */
    @RequestMapping("newestQuote")
    public ModelAndView newestBom() throws IOException {
        ModelAndView mv = new ModelAndView("quote");
        QuoteDao dbInstance = new QuoteDao();

        mv.addObject("action", "submitQuote");
        mv.addObject("button", "ADD");
        mv.addObject("dropDownPartNumber",
                generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("tableData", writeDashboard(QuoteDao.sortByNewest()));

        return mv;
    }

    /**
     * 
     * @return sorted dashboard by oldest record
     * @throws IOException
     */
    @RequestMapping("oldestQuote")
    public ModelAndView oldestBom() throws IOException {
        ModelAndView mv = new ModelAndView("quote");
        QuoteDao dbInstance = new QuoteDao();

        mv.addObject("action", "submitQuote");
        mv.addObject("button", "ADD");
        mv.addObject("dropDownPartNumber",
                generateDropDown(dbInstance.partTypeIds(), dbInstance.partIds(), dbInstance.revIds()));
        mv.addObject("tableData", writeDashboard(QuoteDao.sortByOldest()));

        return mv;
    }

    /**
     * 
     * @param list of QuoteModel Objects carrying data from the database
     * 
     * @return HTML code to populate Tables from Database to UI
     * 
     * @throws IOException
     */
    public String writeDashboard(ArrayList<QuoteModel> list) throws IOException {

        String ss = "";
        for (int i = 0; i < list.size(); i++) {

            String json = list.get(i).getQnpl();
            /**
             * Deserializing Json array or object to QNPL classs
             */
            Gson gson = new Gson();

            QNPL object = gson.fromJson(json, QNPL.class);
            String displayQnpl = "";

            for (int k = 0; k < object.getQuantity().size(); k++) {

                // if next dataset is empty
                if (object.getQuantity().get(k).contentEquals("")) {
                    break;
                }
                /**
                 * generating the format to display Quantity, NRE, Price and Lead Time to UI
                 */
                displayQnpl = displayQnpl + "Quantity : " + object.getQuantity().get(k) + " NRE : $"
                        + object.getNre().get(k) + " PRICE : $" + object.getPrice().get(k) + " LEAD TIME : "
                        + object.getLeadTime().get(k) + ",";

            }

            String[] qnpl = displayQnpl.split(",");
            String qnplData = "";
            for (int j = 0; j < qnpl.length; j++) {

                qnplData = qnplData + "<option>(" + (j + 1) + ") " + qnpl[j] + "</option>";
            }

            ss = ss + ("<tr><td>" + list.get(i).getPartNumber() + "</td><td>" + list.get(i).getSupplierName()
                    + "</td><td>" + list.get(i).getQuoteId() + "</td>" + "<td>" + list.get(i).getQuoteLink()
                    + "</td><td>" + list.get(i).getSupplierLink() + "</td><td>" + list.get(i).getQuoteDate() + "</td>"
                    + "<td>" + list.get(i).getSupplierPn() + "</td><td>" + list.get(i).getManufacturerPn() + "</td><td>"
                    + list.get(i).getCurrency() + "</td><td><select  id=\"select\">\r\n" + qnplData +

                    "</select></td>"

                    + "<td><a href=\"editQuote?supplierName=" + list.get(i).getSupplierName() + "&index="
                    + list.indexOf(list.get(i))
                    + "\"> <button type=\\\"button\\\">EDIT</button></a> <a href=\"deleteQuote?supplierName="
                    + list.get(i).getSupplierName() + "&index=" + list.indexOf(list.get(i))
                    + "\">  <button type=\\\"button\\\">ARCHIVE</button></a></td> <tr>");
        }

        return ss;

    }

    /**
     * Generating drop down XXX-YYYYY-ZZ
     * 
     * @param partTypeIds
     * @param partIds
     * @param revIds
     * @return The html code for Dropdown menu
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
