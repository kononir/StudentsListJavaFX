/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.ArrayList;
import model.Student;

import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import java.io.*;
import javax.xml.transform.stream.*;

import model.*;

/**
 *
 * @author Vlad
 */
public class StudentsFile {
    private String PATH;
    private Document document;
    private ArrayList<Student> students;
    
    private void newFIO(Person person, Element personElement, String personName){
        Element firstNameElement = document.createElement(personName + "FirstName");
        firstNameElement.setTextContent(person.getFirstName());
        personElement.appendChild(firstNameElement);
        Element surnameElement = document.createElement(personName + "Surname");
        surnameElement.setTextContent(person.getSurName());
        personElement.appendChild(surnameElement);
        Element lastNameElement = document.createElement(personName + "LastName");
        lastNameElement.setTextContent(person.getLastName());
        personElement.appendChild(lastNameElement);
    }
    
    private void newSalary(Parent parent, Element parentElement, String parentName){
        MoneyBr salary = parent.getEarnMoney();
        Element salaryElement = document.createElement(parentName + "Salary");
        parentElement.appendChild(salaryElement);
        Element rublesElement = document.createElement(parentName + "Rubles");
        rublesElement.setTextContent(String.valueOf(salary.getRubles()));
        salaryElement.appendChild(rublesElement);
        Element pennyElement = document.createElement(parentName + "Penny");
        pennyElement.setTextContent(String.valueOf(salary.getPenny()));
        salaryElement.appendChild(pennyElement);
    }
    
    private void writeDocument() 
    {
        try{
            Transformer transformerFactory = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            StreamResult streamRes = new StreamResult(fileOutputStream);
         
            transformerFactory.transform(source, streamRes);
        }
        catch (TransformerException e){
            e.printStackTrace(System.out);
        }
        catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        }
    }
    
    public void saveDocument(ArrayList<Student> studentsArray, String PATH) 
    { 
        this.PATH = PATH;
        try{
            DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
            document = docBuilder.newDocument();
            Element studentsElement = document.createElement("students");
            document.appendChild(studentsElement);
            if(studentsArray.isEmpty())
                return;
            
            studentsArray.forEach((student) -> {
                Element studentElement = document.createElement("student");
                studentsElement.appendChild(studentElement);
                newFIO(student, studentElement, "student");
                
                Parent father = student.getFather();
                Element fatherElement = document.createElement("father");
                studentElement.appendChild(fatherElement);
                newFIO(father, fatherElement, "father");
                newSalary(father, fatherElement, "father");
                
                Parent mother = student.getMother();
                Element motherElement = document.createElement("mother");
                studentElement.appendChild(motherElement);
                newFIO(mother, motherElement, "mother");
                newSalary(mother, motherElement, "mother");
                
                Element numberOfBrothersElement = document.createElement("numberOfBrothers");
                numberOfBrothersElement.setTextContent(String.valueOf(student.getNumberOfBrothers()));
                studentElement.appendChild(numberOfBrothersElement);
                
                Element numberOfSistersElement = document.createElement("numberOfSisters");
                numberOfSistersElement.setTextContent(String.valueOf(student.getNumberOfSisters()));
                studentElement.appendChild(numberOfSistersElement);
            });
        } catch(ParserConfigurationException e){
            e.printStackTrace(System.out);
        } finally {
            if(document != null)
                writeDocument();
        }
    }
    
    DefaultHandler handler = new DefaultHandler(){
        String currentQName;

        Student student;
        String studentFirstName;
        String studentSurname;
        String studentLastName;
        String fatherFirstName;
        String fatherSurname;
        String fatherLastName;
        int fatherRubles;
        int fatherPenny;
        String motherFirstName;
        String motherSurname;
        String motherLastName;
        int motherRubles;
        int motherPenny;
        int numberOfBrothers;
        int numberOfSisters;
        Parent mother;
        Parent father;

        @Override
        public void startDocument() throws SAXException{
            System.out.println("Start analysis");
            students = new ArrayList();
        }
        @Override
        public void endDocument() throws SAXException{
            System.out.println("Finish analysis");
        }
        @Override
        public void startElement(String uri, String localName, 
                String qName, Attributes attributes)
                throws SAXException
        {
            currentQName = qName;
        }
        @Override
        public void characters(char ch[], int start, int length)
                throws SAXException
        {
            switch(currentQName){
                case "studentFirstName":
                    studentFirstName = new String(ch, start, length);
                    break;    
                case "studentSurname":
                    studentSurname = new String(ch, start, length);
                    break;
                case "studentLastName":
                    studentLastName = new String(ch, start, length);
                    break;
                case "fatherFirstName":
                    fatherFirstName = new String(ch, start, length);
                    break;    
                case "fatherSurname":
                    fatherSurname = new String(ch, start, length);
                    break;
                case "fatherLastName":
                    fatherLastName = new String(ch, start, length);
                    break;
                case "fatherRubles":
                    fatherRubles = new Integer(new String(ch, start, length));
                    break;    
                case "fatherPenny":
                    fatherPenny = new Integer(new String(ch, start, length));
                    MoneyBr fatherSalary = new MoneyBr(fatherRubles, fatherPenny);
                    father = new Parent(
                            fatherFirstName, 
                            fatherSurname,
                            fatherLastName,
                            fatherSalary
                    );
                    break;
                case "motherFirstName":
                    motherFirstName = new String(ch, start, length);
                    break;
                case "motherSurname":
                    motherSurname = new String(ch, start, length);
                    break;    
                case "motherLastName":
                    motherLastName = new String(ch, start, length);
                    break;
                case "motherRubles":
                    motherRubles = new Integer(new String(ch, start, length));
                    break;
                case "motherPenny":
                    motherPenny = new Integer(new String(ch, start, length));
                    MoneyBr motherSalary = new MoneyBr(motherRubles, motherPenny);
                    mother = new Parent(
                            motherFirstName, 
                            motherSurname,
                            motherLastName,
                            motherSalary
                    );
                    break;   
                case "numberOfBrothers":
                    numberOfBrothers = new Integer(new String(ch, start, length));
                    break;
                case "numberOfSisters":
                    numberOfSisters = new Integer(new String(ch, start, length));
                    student = new Student(
                            studentFirstName,
                            studentSurname,
                            studentLastName,
                            father,
                            mother,
                            numberOfBrothers,
                            numberOfSisters
                    );
                    students.add(student);
                    break;
                default:
                    break;
            }
        }
        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException
        {
            super.endElement(uri, localName, qName);
        }
    };
    
    public ArrayList<Student> loadDocument(String PATH){
        try{
            SAXParserFactory saxParserFact = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFact.newSAXParser();
            saxParser.parse(PATH, handler);  
        } catch(IOException | ParserConfigurationException | SAXException e){
            e.printStackTrace(System.out);
        }
        return students;
    }
    
    public StudentsFile(String PATH){
        this.PATH = PATH;
    }
    public StudentsFile(){
        this.PATH = "";
    }
}
