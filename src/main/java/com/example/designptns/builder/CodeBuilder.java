package com.example.designptns.builder;

import java.util.ArrayList;
import java.util.List;

public class CodeBuilder
{
    //private String className, name, type;
    private List<String> properties;
    public CodeBuilder(String className)
    {
        properties = new ArrayList<>();
        properties.add(String.format("public class %s\n{\n", className));
    }
    
    public CodeBuilder addField(String name, String type)
    {
        properties.add(String.format("  public %s %s;\n", type, name));
        return this;
    }
    
    @Override
    public String toString()
    {
        StringBuilder classStructure = new StringBuilder();
        properties.stream().forEach(property -> {classStructure.append(property);});
        classStructure.append("}");
        return classStructure.toString();
    }
    
    public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
		
	}
}
