package com.isha.donation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

import com.isha.donation.Service.DonorService;
import com.isha.donation.Service.IshaDonorService;
import com.isha.donation.entity.Donor;

@Controller
public class DownloadController {

	@Autowired
	private IshaDonorService ishaDonorService;
	
	
	
	 
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/downloadxls",method=RequestMethod.GET)
		public ResponseEntity<?> download(HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			System.out.println("download");
	String FILE_NAME="C:/xls/isha.xlsx"; 
	
	File file=new File(FILE_NAME);
	
	
	 XSSFWorkbook workbook = new XSSFWorkbook();
       XSSFSheet sheet = workbook.createSheet("isha");
        

             
       
       int rowNum = 0;
       System.out.println("Creating excel");
       
       
       @SuppressWarnings("unchecked")
	List<Donor> listofdonor=ishaDonorService.findAllDonor();
       
       for(Donor d:listofdonor){
    	   System.out.println(d);
       }
     
       

       for (Donor donor : listofdonor) {
           Row row = sheet.createRow(rowNum++);
           int colNum = 0;
            
               Cell cell = row.createCell(colNum++);
               
               row.createCell(colNum++).setCellValue(donor.getDonorPhoneNumber());
               row.createCell(colNum++).setCellValue(donor.getDonorName());
               row.createCell(colNum++).setCellValue(donor.getDonorEmail());
               row.createCell(colNum++).setCellValue(donor.getAmount());
               row.createCell(colNum++).setCellValue(donor.getDonorStatus());
               row.createCell(colNum++).setCellValue(donor.getDonorRegion());
               row.createCell(colNum++).setCellValue(donor.getDonorState());
               row.createCell(colNum++).setCellValue(donor.getDonorCity());
               row.createCell(colNum++).setCellValue(donor.getCenter());
               row.createCell(colNum++).setCellValue(donor.getBankAccountholderName());
               row.createCell(colNum++).setCellValue(donor.getBankName());
               row.createCell(colNum++).setCellValue(donor.getBankBranch());
               row.createCell(colNum++).setCellValue(donor.getBankAccountNumber());
               row.createCell(colNum++).setCellValue(donor.getBankMICR());
                   
               row.createCell(colNum++).setCellValue(donor.getBankIfscCode());
               row.createCell(colNum++).setCellValue(donor.getBankAccountType());
               row.createCell(colNum++).setCellValue(donor.getDonationStartDate());
               row.createCell(colNum++).setCellValue(donor.getDonationEndDate());
               row.createCell(colNum++).setCellValue(donor.getDonationFrequency());
               row.createCell(colNum++).setCellValue(donor.getTppsConsumerCode());
               row.createCell(colNum++).setCellValue(donor.getCreateDonordate());
               row.createCell(colNum++).setCellValue(donor.getDonorComments() );
               row.createCell(colNum++).setCellValue(donor.getDonorEmail());
                   
                 
           
       }
       
       response.setContentType("application/vnd.ms-excel");

       response.setHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);
     
       byte[] bytes=FileUtils.readFileToByteArray(file);
		
		FileCopyUtils.copy(bytes, response.getOutputStream()); 
		 
		OutputStream os = response.getOutputStream();

       

       try {
           FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
           workbook.write(outputStream);
           workbook.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

       return new ResponseEntity("downloaded succesfully ",HttpStatus.OK);
	
	
}





/*public @ResponseBody void download(@RequestParam("file")MultipartFile multipartFile){
	
	
	String filename="";
	try{
		filename=multipartFile.getOriginalFilename();
		byte[] b=multipartFile.getBytes();
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File("temp/"+filename)));
		String fileName = multipartFile.getOriginalFilename();
		String extension = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
		
		
		File csvFile = null;
		boolean isDuplicatesFound = false;
		if(extension.equals("xls") |extension.equals("")){

			File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + multipartFile.getOriginalFilename());
			
			multipartFile.transferTo(tmpFile);
			
			csvFile = dataToCsvFile(tmpFile);
			
			byte[] fileBytes = readBytesFromFile(csvFile);
			 
			Scanner sc=new Scanner(csvFile);
			ArrayList< ArrayList<String>> donorlist = new ArrayList< ArrayList<String>>();
			while(sc.hasNext()){
								
				String line=sc.nextLine();
				String[] lineArr = line.split(",");
				ArrayList<String> data = new ArrayList<String>(Arrays.asList(lineArr));
				donorlist.add(data);
				
			}
					
			 
			
			
			 
			//biometricData.setContent(multipartFile.getBytes());
			//biometricData.setContent(fileBytes);

			//START: Read the data in file and insert the values to list

		
		
		
		bufferedOutputStream.write(b);
		bufferedOutputStream.close();
		
		}
	}catch (Exception e) {

	}
	
	

	 
	
	
	
	
	 
	
	
	String filePath="C:/xls/";
	File f=new File(filePath);
	WorkbookSettings wbSettings = new WorkbookSettings();

   wbSettings.setLocale(new Locale("en", "EN"));

   WritableWorkbook workbook = Workbook.createWorkbook(f, wbSettings);
   
   WritableSheet wsheet=workbook.getSheet(arg0)
   
   	for(Donor d:list){
   
   Formula formula = new Formula(0, 10, d.getDonorId().toString());
   
   
   
	
	Sheet sheet = workbook.createSheet("User Detail");
   sheet.setDefaultColumnWidth(30);
   
   
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
	
}*/


	
}



	 
	/*@RequestMapping(value="/downloadxls",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> download(){
		
		List<Donor> list=(List<Donor>)donorService.findAll();
		
		
		
	}*/
	
	

