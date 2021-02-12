package dev.troll.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.troll.entities.GradeFormat;
import dev.troll.util.JDBCConnection;

public class GradeFormatDAOImp 
{
	//does not need to be cahnged
public static Connection conn = JDBCConnection.getConnection();
	
	public GradeFormat getGradeFormatById(int gradeFormatId)
	{
		try 
		{
			String sql = "SELECT * FROM Grade_Formats WHERE format_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(gradeFormatId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				GradeFormat gf = new GradeFormat();
				
				gf.setId(gradeFormatId);
				gf.setGradeValue(rs.getString("GRADE_VALUE"));
				gf.setGradeFormat(rs.getInt("GRADE_FORMAT"));
				gf.setPassfailBool(rs.getInt("PASSFAIL_BOOL"));

				return gf;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public GradeFormat getGradeFormatByValue(String value)
	{
		try 
		{
			String sql = "SELECT * FROM Grade_Formats WHERE grade_value = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, value);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				GradeFormat gf = new GradeFormat();

				gf.setId(rs.getInt("FORMAT_ID"));
				gf.setGradeValue(value);
				gf.setGradeFormat(rs.getInt("GRADE_FORMAT"));
				gf.setPassfailBool(rs.getInt("PASSFAIL_BOOL"));

				return gf;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public GradeFormat getGradeFormatByFormat(int format)
	{
		try 
		{
			String sql = "SELECT * FROM Grade_Formats WHERE grade_format = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(format));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				GradeFormat gf = new GradeFormat();

				gf.setId(rs.getInt("FORMAT_ID"));
				gf.setGradeValue(rs.getString("GRADE_VALUE"));
				gf.setGradeFormat(format);
				gf.setPassfailBool(rs.getInt("PASSFAIL_BOOL"));

				return gf;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}

	public ArrayList<GradeFormat> getAllGradeFormats()
	{
		try
		{
			ArrayList<GradeFormat> allGfs = new ArrayList<GradeFormat>();
			String sql = "SELECT * FROM Grade_Formats";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				GradeFormat gf = new GradeFormat();

				gf.setId(rs.getInt("FORMAT_ID"));
				gf.setGradeValue(rs.getString("GRADE_VALUE"));
				gf.setGradeFormat(rs.getInt("GRADE_FORMAT"));
				gf.setPassfailBool(rs.getInt("PASSFAIL_BOOL"));
				
				allGfs.add(gf);
			}
			return allGfs;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
