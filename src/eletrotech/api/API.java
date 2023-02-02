/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eletrotech.api;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import static javafx.scene.text.FontPosture.REGULAR;
 
/**
 *
 * @author Arthur
 */
public class API {
    public static void main(String[] args) throws IOException {
        getSchedules();
    }
    
    public static boolean createService(Service service) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/services/");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        String jsonData = "{\"name\":\""+service.getName()+"\",";
        jsonData += "\"value\":\""+service.getValue()+"\",";
        jsonData += "\"description\":\""+service.getDescription()+"\",";
        jsonData += "\"disponibility\":\""+service.getDisponibility()+"\"}";
        outStreamWriter.write(jsonData);
        outStreamWriter.flush();
        outStreamWriter.close();
        outStream.close();
        System.out.println(jsonData);
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
        
        
        return responseCode == HttpURLConnection.HTTP_OK; // success
    }
    public static boolean createEmployee(Employee employee) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/employees/");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        String jsonData = "{\"username\":\""+employee.getUsername()+"\",";
        jsonData += "\"email\":\""+employee.getEmail()+"\",";
        jsonData += "\"address\":\""+employee.getAddress()+"\",";
        jsonData += "\"password\":\""+employee.getPassword()+"\",";
        jsonData += "\"role\":\""+employee.getRole()+"\"}";
        outStreamWriter.write(jsonData);
        outStreamWriter.flush();
        outStreamWriter.close();
        outStream.close();
        
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
        
        
        return responseCode == HttpURLConnection.HTTP_OK; // success
    }
    public static boolean login(String email, String password) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/employees/login");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        String jsonData = "{\"email\":\""+email+"\",";
        jsonData += "\"password\":\""+password+"\"}";
        outStreamWriter.write(jsonData);
        outStreamWriter.flush();
        outStreamWriter.close();
        outStream.close();
        
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
        
        
        return responseCode == HttpURLConnection.HTTP_OK; // success
    }
    
    public static Schedule[] getSchedules() throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/schedules");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            Gson gson = new Gson();
            Schedule[] schedules = gson.fromJson(json, Schedule[].class);
            return schedules;
        } else {
            return null;
        }
    }
    public static Employee[] getTechnicians() throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/employees/technicians");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            Gson gson = new Gson();
            Employee[] employees = gson.fromJson(json, Employee[].class);
            return employees;
        } else {
            return null;
        }
    }
    public static boolean setTechniciansToSchedule(int scheduleId,int technicianId) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/schedules/"+scheduleId);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("PUT");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        outStreamWriter.write("{\"employee\":\""+technicianId+"\"}");
        outStreamWriter.flush();
        outStreamWriter.close();
        outStream.close();
        
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
        
        
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            return true;
        } else {
            return false;
        }
    }
    public static Employee[] getEmployees() throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/employees");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
	int responseCode = con.getResponseCode();
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            Gson gson = new Gson();
            Employee[] employees = gson.fromJson(json, Employee[].class);
            return employees;
        } else {
            return null;
        }
    }
    public static boolean patchEmployee(Employee employee) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/employees/"+employee.getId());
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("PUT");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        String jsonData = "{\"username\":\""+employee.getUsername()+"\",";
        jsonData += "\"email\":\""+employee.getEmail()+"\",";
        jsonData += "\"address\":\""+employee.getAddress()+"\",";
        jsonData += "\"role\":\""+employee.getRole()+"\"}";
        outStreamWriter.write(jsonData);
        outStreamWriter.flush();
        outStreamWriter.close();
        outStream.close();
        
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
        
        
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            return true;
        } else {
            return false;
        }
    }
    public static Service[] getServices() throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/services");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
	int responseCode = con.getResponseCode();
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            Gson gson = new Gson();
            Service[] services = gson.fromJson(json, Service[].class);
            return services;
        } else {
            return null;
        }
    }
    public static boolean patchService(Service service) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/services/"+service.getId());
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("PUT");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        String jsonData = "{\"name\":\""+service.getName()+"\",";
        jsonData += "\"description\":\""+service.getDescription()+"\",";
        jsonData += "\"value\":\""+service.getValue()+"\",";
        jsonData += "\"disponibility\":\""+service.getDisponibility()+"\"}";
        outStreamWriter.write(jsonData);
        outStreamWriter.flush();    
        outStreamWriter.close();
        outStream.close();
        
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
        
        
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean generateOS(Schedule schedule) {
           //https://kb.itextpdf.com/home/it5kb/examples/101-a-very-simple-table
            
        Document document = new Document();
          try {

              String documentName = "OS_" + schedule.getId() + "_" + schedule.getService().getName() + ".pdf";
              
              PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\Documents\\"+documentName));
              document.open();

              // adicionando um parágrafo no documento
              Font font = new Font(Font.FontFamily.HELVETICA, 20,Font.BOLD);
              Font smallfont = new Font(Font.FontFamily.HELVETICA, 12,Font.NORMAL);
              
              Paragraph title = new Paragraph("ORDEM DE SERVIÇO", font);
              title.setAlignment(Element.ALIGN_CENTER);
              
              
              PdfPTable table = new PdfPTable(2);
                table.setTotalWidth(new float[]{ 200, 200 });
                table.setSpacingAfter(50);
                table.setSpacingBefore(50);
                table.setLockedWidth(true);
                PdfContentByte cb = writer.getDirectContent();
                
                // ---------------
                PdfPCell label = new PdfPCell(new Phrase("Serviço:"));
                label.setFixedHeight(25);
                label.setBorder(Rectangle.BOX);
                label.setColspan(1);
                label.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(label);

                PdfPCell value = new PdfPCell(new Phrase(schedule.getService().getName()));
                value.setFixedHeight(25);
                value.setBorder(Rectangle.BOX);
                value.setColspan(1);
                value.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(value);

                // ------------------
                label = new PdfPCell(new Phrase("Descrição do serviço:"));
                label.setFixedHeight(25);
                label.setBorder(Rectangle.BOX);
                label.setColspan(1);
                label.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(label);

                value = new PdfPCell(new Phrase(schedule.getService().getDescription()));
                value.setFixedHeight(25);
                value.setBorder(Rectangle.BOX);
                value.setColspan(1);
                value.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(value);

                // ------------------
                label = new PdfPCell(new Phrase("Data do atendimento:"));
                label.setFixedHeight(25);
                label.setBorder(Rectangle.BOX);
                label.setColspan(1);
                label.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(label);

                String[] dateArray = schedule.getDate().substring(0, 10).split("-");
                String date = dateArray[2]+"/"+dateArray[1]+"/"+dateArray[0];

                value = new PdfPCell(new Phrase(date));
                value.setFixedHeight(25);
                value.setBorder(Rectangle.BOX);
                value.setColspan(1);
                value.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(value);

                // ------------------
                label = new PdfPCell(new Phrase("Hora do atendimento:"));
                label.setFixedHeight(25);
                label.setBorder(Rectangle.BOX);
                label.setColspan(1);
                label.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(label);

                value = new PdfPCell(new Phrase(schedule.getTime()));
                value.setFixedHeight(25);
                value.setBorder(Rectangle.BOX);
                value.setColspan(1);
                value.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(value);

                // ------------------
                label = new PdfPCell(new Phrase("Valor do serviço:"));
                label.setFixedHeight(25);
                label.setBorder(Rectangle.BOX);
                label.setColspan(1);
                label.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(label);

                value = new PdfPCell(new Phrase(schedule.getService().getValue()));
                value.setFixedHeight(25);
                value.setBorder(Rectangle.BOX);
                value.setColspan(1);
                value.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(value);

                // ------------------
                label = new PdfPCell(new Phrase("Técnico responsável:"));
                label.setFixedHeight(25);
                label.setBorder(Rectangle.BOX);
                label.setColspan(1);
                label.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(label);

                value = new PdfPCell(new Phrase(schedule.getEmployee().getUsername()));
                value.setFixedHeight(25);
                value.setBorder(Rectangle.BOX);
                value.setColspan(1);
                value.setBackgroundColor(new BaseColor(255, 240, 212));
                table.addCell(value);

                
                Image img = Image.getInstance("C:\\Users\\Aluno_Noite\\3D Objects\\drive-download-20230202T103809Z-001\\Eletro_Tech_DESKTOP\\EletroTech\\src\\eletrotech\\img\\logo_Orange.png");
                img.setAlignment(Element.ALIGN_CENTER);
                
                document.add(img);
                document.add(title);
                document.add(table);

                font = new Font(Font.FontFamily.HELVETICA, 16,Font.NORMAL);                
                Paragraph signature = new Paragraph("Assinatura do ténico: __________________________________________", font);
                signature.setAlignment(Element.ALIGN_CENTER);
                document.add(signature);
    }
          
          catch(DocumentException | IOException de) {
              System.err.println(de.getMessage());
          }
          document.close();
          System.out.println("PDF CRIADO");
          return true;
    }
    
    public static boolean finishService(int id) throws MalformedURLException, IOException { 
        URL obj = new URL("http://54.207.200.19:8080/schedules/"+id+"/finish");
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("PUT");
	con.setRequestProperty("User-Agent", "Eletro_Tech_DESKTOP");
        con.setRequestProperty("Content-Type", "application/json");
        
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
        
                
        return responseCode == HttpURLConnection.HTTP_OK; // success
    }
}
