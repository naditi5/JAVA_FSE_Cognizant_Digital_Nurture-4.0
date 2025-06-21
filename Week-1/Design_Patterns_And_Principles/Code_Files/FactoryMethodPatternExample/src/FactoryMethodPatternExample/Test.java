package FactoryMethodPatternExample;
public class Test {

	public static void main(String[] args) {
		DocumentFactory wordFactory = new WordDocFactory();
		Document wordDoc = wordFactory.createDocument();
		wordDoc.open();
		
		DocumentFactory pdfFactory = new PdfDocFactory();
		Document pdfDoc = pdfFactory.createDocument();
		pdfDoc.open();
		
		DocumentFactory excelFactory = new ExcelDocFactory();
		Document excelDoc = excelFactory.createDocument();
		excelDoc.open();
	}

}
