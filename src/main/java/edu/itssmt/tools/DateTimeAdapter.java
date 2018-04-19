package edu.itssmt.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.springframework.stereotype.Component;

/**
 * 
 * @author badak
 *
 */
@Component
public class DateTimeAdapter extends XmlAdapter<String, Date> {

	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date unmarshal(String v) throws Exception {
		return format.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return format.format(v);
	}

}
