package gov.weather;

import org.junit.Test;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

import static org.junit.Assert.*;

import javax.xml.bind.*;


/**
 * Created by gunther on 10/10/16.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53597");

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));
        assertEquals("Result did not match expected value", "43.1866,-89.452", dwml.getLatLonList());
    }
}