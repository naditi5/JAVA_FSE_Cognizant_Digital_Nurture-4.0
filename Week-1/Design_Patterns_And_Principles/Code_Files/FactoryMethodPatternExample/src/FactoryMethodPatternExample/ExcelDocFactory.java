package FactoryMethodPatternExample;
public class ExcelDocFactory extends DocumentFactory{
	@Override
	public Document createDocument() {
		return new ExcelDocument();
	}

}
