package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "first")
public class First {

    @XmlElement(name = "second")
    public String item1 = "some string";

    @XmlElement(name = "second")
    public String item2 = "some string";

    @XmlElement(name = "second")
    public String item3 = "need CDATA because of <second>";
}
