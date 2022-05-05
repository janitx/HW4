package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "filtersProduct")
public class FilterProductModel {

    @JacksonXmlElementWrapper(localName = "filters")
    @JacksonXmlProperty(localName = "filter")
    protected List<ProductModel> collection;

    public FilterProductModel() {
    }

    public FilterProductModel(List<ProductModel> collection) {
        this.collection = collection;
    }

    public List<ProductModel> getCollection() {
        return collection;
    }

    @Override
    public String toString() {
        return "FilterProductModel{" +
                "collection=" + collection +
                '}';
    }
}

