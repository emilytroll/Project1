package dev.troll.services;

import java.util.ArrayList;

import dev.troll.daos.GradeFormatDAOImp;
import dev.troll.entities.GradeFormat;

public class GradeFormatService 
{
	private GradeFormatDAOImp gfi = new GradeFormatDAOImp();
	
	public GradeFormat getGradeFormatById(int gradeFormatId)
	{
		return gfi.getGradeFormatByFormat(gradeFormatId);
	}

	public GradeFormat getGradeFormatByValue(String value)
	{
		return gfi.getGradeFormatByValue(value);
	}

	public GradeFormat getGradeFormatByFormat(int format)
	{
		return gfi.getGradeFormatByFormat(format);
	}

	public ArrayList<GradeFormat> getAllGradeFormats()
	{
		return gfi.getAllGradeFormats();
	}

}
