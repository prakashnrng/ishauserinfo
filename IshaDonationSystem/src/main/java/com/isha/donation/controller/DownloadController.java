package com.isha.donation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.isha.donation.Service.DonorService;
import com.isha.donation.Service.IshaDonorService;
import com.isha.donation.entity.Donor;
import com.isha.donation.entity.UploadDonor;
import com.isha.donation.excelhead.ExcelColumn;

@Controller
public class DownloadController {

	@Autowired
	private DonorService donorService;
	
	@Autowired
	private IshaDonorService ishaDonorService;
	
	/*@Autowired
	pri
	*/
	
	
	@Autowired
	private ExcelColumn excelColumn;
	
	
	
	 
		@SuppressWarnings({ "unchecked", "deprecation" })
		@RequestMapping(value="/downloadxls",method=RequestMethod.GET)
		public ResponseEntity download(HttpServletRequest request,HttpServletResponse response) {
			int rowNum = 0;
			int coulumncount=0;
			System.out.println("download");
	String FILE_NAME="C:/xls/isha.xls"; 
	
	File file=new File(FILE_NAME);
	//response.setContentType("application/xls");
	  
  //   response.setContentType("application/vnd.ms-excel");

  //  response.setHeader("Content-Disposition", "attachment; filename=" + "isha.xls");
	
	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-disposition", "attachment;filename=isha.xls");
    
	
    response.setContentLength((int) file.length());

    HSSFWorkbook workbook=new HSSFWorkbook();
    HSSFSheet sheet=workbook.createSheet("isha");
    
    /*
	 XSSFWorkbook workbook = new XSSFWorkbook();
       XSSFSheet sheet = workbook.createSheet("isha");
        sheet.autoSizeColumn(1000000);
    */  
       
       System.out.println("Creating excel");
       
       
       @SuppressWarnings("unchecked")
       String status="new";
	List<Donor> listofdonor=ishaDonorService.findAllDonor(status);
       
       for(Donor d:listofdonor){
    	   sheet.setColumnWidth(0, 3000);
    	   System.out.println(d);
       }
       int rowcoulumn=0;
     int count=0;
     sheet.setColumnWidth(0, 3000);
     //sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 2));
     Row rowheader = sheet.createRow(rowNum++);
     
     Cell cellcolumn = rowheader.createCell(coulumncount);
     CellStyle style = workbook.createCellStyle();
     style.setFillBackgroundColor(IndexedColors.YELLOW .getIndex());
     //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
     style.setBorderBottom(CellStyle.BORDER_THIN);
     style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
     style.setBorderLeft(CellStyle.BORDER_THIN);
     style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
     style.setBorderRight(CellStyle.BORDER_THIN);
     style.setRightBorderColor(IndexedColors.BLACK.getIndex());
     style.setBorderTop(CellStyle.BORDER_THIN);
     style.setTopBorderColor(IndexedColors.BLACK.getIndex());

     
      cellcolumn=rowheader.createCell(rowcoulumn++);
     cellcolumn.setCellStyle(style);
     cellcolumn.setCellValue("Consumer Code");
     rowheader.createCell(rowcoulumn++).setCellValue("Applicant Name");
     rowheader.createCell(rowcoulumn++).setCellValue("BANKACCOUNTHOLDERNAME");
     rowheader.createCell(rowcoulumn++).setCellValue("BANKNAME");
     rowheader.createCell(rowcoulumn++).setCellValue("BRANCHNAME");
     rowheader.createCell(rowcoulumn++).setCellValue("BANKACCOUNTNUMBER");
     rowheader.createCell(rowcoulumn++).setCellValue("MICR");    
     rowheader.createCell(rowcoulumn++).setCellValue("IFSCCODE");
     rowheader.createCell(rowcoulumn++).setCellValue("ACCOUNTTYPE");
    rowheader.createCell(rowcoulumn++).setCellValue("EMAIL_ID");
    rowheader.createCell(rowcoulumn++).setCellValue("Mobile_No");  
    rowheader.createCell(rowcoulumn++).setCellValue("STARTDATE");
    rowheader.createCell(rowcoulumn++).setCellValue("ENDDATE");
         rowheader.createCell(rowcoulumn++).setCellValue("AMOUNT");
         rowheader.createCell(rowcoulumn++).setCellValue("FREQUENCY");
              
        	
        	
         

       for (Donor donor : listofdonor) {
           Row row = sheet.createRow(rowNum++);
           sheet.setColumnWidth(0, 3000);
           int colNum = 0;
            
               Cell cell = row.createCell(colNum);
                     row.createCell(colNum++).setCellValue(donor.getDonorId());
               row.createCell(colNum++).setCellValue(donor.getDonorName());
               row.createCell(colNum++).setCellValue(donor.getBankAccountholderName());
               row.createCell(colNum++).setCellValue(donor.getBankName());
               row.createCell(colNum++).setCellValue(donor.getBankBranch());
               row.createCell(colNum++).setCellValue(donor.getBankAccountNumber());
               row.createCell(colNum++).setCellValue(donor.getBankMICR());
               row.createCell(colNum++).setCellValue(donor.getBankIfscCode());
               row.createCell(colNum++).setCellValue(donor.getBankAccountType());
               row.createCell(colNum++).setCellValue(donor.getDonorEmail());
               row.createCell(colNum++).setCellValue(donor.getDonorPhoneNumber());
               row.createCell(colNum++).setCellValue(donor.getDonationStartDate());
               row.createCell(colNum++).setCellValue(donor.getDonationEndDate());
               row.createCell(colNum++).setCellValue(donor.getAmount());
               row.createCell(colNum++).setCellValue(donor.getDonationFrequency());
                          
               
       }
      try{
       
       FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
       workbook.write(outputStream);  
       workbook.close();
       
       
       byte[] bytes=FileUtils.readFileToByteArray(file);
		
		FileCopyUtils.copy(bytes, response.getOutputStream()); 
		 
		OutputStream os = response.getOutputStream();
		
		
		 FileInputStream fileInputStream = new FileInputStream(file);
	       OutputStream responseOutputStream = response.getOutputStream();
	       
	       int bytess;
	       while ((bytess = fileInputStream.read()) != -1) {
	           responseOutputStream.write(bytess);
	       }
	       fileInputStream.close();
	       responseOutputStream.close();
		os.close();
		responseOutputStream.flush();
		
      }catch (Exception e) {
		 e.printStackTrace();
	}
      /* try {
           FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
           workbook.write(outputStream);
           workbook.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }*/

       return new ResponseEntity("downloaded succesfully ",HttpStatus.OK);
	
	
}

		
		
		@RequestMapping(value="/uploadxls",method=RequestMethod.POST)
		public @ResponseBody void upload(@RequestParam("file")MultipartFile multipartFile){
			int count=0;
			try{
				
			 HSSFWorkbook workbook=new HSSFWorkbook(multipartFile.getInputStream());
			    HSSFSheet sheet=workbook.getSheetAt(0);
			    
			    while(count<sheet.getLastRowNum()){
			    	int cell=0;
			    	HSSFRow row = sheet.getRow(count++);
			    	UploadDonor uploaddonor=new UploadDonor();
			    	uploaddonor.setName(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setEmail(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setAmount(row.getCell(cell++).getNumericCellValue());
			    	uploaddonor.setStatus(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setRegion(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setState(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setCity(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setCenter(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setBankAccountholderName(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setBankName(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setBranchName(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setBankAccountNumber(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setBankMICR((int)row.getCell(cell++).getNumericCellValue());
			    	uploaddonor.setBankIfscCode(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setBankAccountType(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setStartDate(row.getCell(cell++).getDateCellValue());
			    	uploaddonor.setEndDate(row.getCell(cell++).getDateCellValue());
			    	uploaddonor.setFrequency(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setTppsConsumerCode(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setCreateDate(row.getCell(cell++).getStringCellValue());
			    	uploaddonor.setCreateDate(row.getCell(cell++).getStringCellValue());
			    	ishaDonorService.saveUploadedDonor(uploaddonor);
			    }
			    
			    
			    
			    
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}


		 
/*@RequestMapping(value="/uploadxls",method=RequestMethod.POST)
 public @ResponseBody void upload(@RequestParam("file")MultipartFile multipartFile){
	
	
	String filename="";
	try{
		filename=multipartFile.getOriginalFilename();
		byte[] b=multipartFile.getBytes();
		//BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File("temp/"+filename)));
		String fileName = multipartFile.getOriginalFilename();
		String extension = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
		
		
		File csvFile = null;
		boolean isDuplicatesFound = false;
		if(extension.equals("xls") |extension.equals("xlsx")){

			File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + multipartFile.getOriginalFilename());
			
			multipartFile.transferTo(tmpFile);
			
			csvFile = dataToCsvFile(tmpFile);
			
			byte[] fileBytes = readBytesFromFile(csvFile);
			
			
			
			
			  Scanner sc=new Scanner(csvFile);
			ArrayList< ArrayList<String>> donorlist = new ArrayList< ArrayList<String>>();
			ArrayList<String> data=null;
			while(sc.hasNext()){
								
				String line=sc.nextLine();
				String[] lineArr = line.split(",");
				 data = new ArrayList<String>(Arrays.asList(lineArr));
				donorlist.add(data);
			
				
			}
			  
			
			 
			 
			//biometricData.setContent(multipartFile.getBytes());
			//biometricData.setContent(fileBytes);

			//START: Read the data in file and insert the values to list

		
		
		
		
		
		}
	}catch (Exception e) {

	}
	
	

	 
	
	
	
	
	 
	 
   
   
   	}
 


private ArrayList<HashMap<String, ArrayList<ArrayList<String>>>> getMapFromList(ArrayList< ArrayList<String>> donorlist){
	ArrayList<String> loginData= new ArrayList<String>();
	ArrayList<String> logoutData= new ArrayList<String>();
	ArrayList<ArrayList<String>> nextData = new ArrayList<ArrayList<String>>();
	HashMap<String, ArrayList<ArrayList<String>>> userData= new HashMap<String, ArrayList<ArrayList<String>>>();
	String userId=null;
	ArrayList<HashMap<String, ArrayList<ArrayList<String>>>> attendanceList = new ArrayList<HashMap<String, ArrayList<ArrayList<String>>>>();
	for (int i=0; i<donorlist.size(); i++) {
		nextData = new ArrayList<ArrayList<String>>();
		loginData= donorlist.get(i);
		logoutData= new ArrayList<String>();
		String loginDate = loginData.get(1);
		userId=loginData.get(0);
		for(int j=i+1 ;j<donorlist.size();j++){
			logoutData= donorlist.get(j);
			String logoutDate = logoutData.get(1);
			String userId1=logoutData.get(0);
			if(userId1.equals(userId) && loginDate.equals(logoutDate)){
				nextData.add(loginData);
				nextData.add(logoutData);
			}
		}
		if(nextData.size()>0){
			userData.put(userId, nextData);
			nextData = null;
			attendanceList.add(userData);
			userData = new HashMap<String, ArrayList<ArrayList<String>>>();
		}
	}
	return attendanceList;
}




private File dataToCsvFile(File file)throws IOException{
	Scanner sc=new Scanner(file);
	File csvFile=new File("isha.csv");
	FileWriter fileWriter=new FileWriter(csvFile);
	while(sc.hasNext()){
		String line=sc.nextLine();
		line=(line.trim()).replaceAll("\\s",",");
		fileWriter.write(line);
		fileWriter.write("\n");
		
		
	}
	fileWriter.close();
	sc.close();
	return csvFile;
	
}

private static byte[] readBytesFromFile(File file){
	FileInputStream fis=null;
	byte[] bytes=null;
	try{
		bytes=new byte[((int)file.length())];
		fis=new FileInputStream(file);
		fis.read(bytes);
	}catch (Exception e) {
			e.printStackTrace();
	}finally {
		if(fis!=null){
			try{
				fis.close();
			}catch (Exception e) {
					e.printStackTrace();
			}
		}
	}
	
	return bytes;
	
} 
*/

		
		 
		
		
	
}





	 
	/*@RequestMapping(value="/downloadxls",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> download(){
		
		List<Donor> list=(List<Donor>)donorService.findAll();
		
		
		
	}*/
	
	

