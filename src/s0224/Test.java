package s0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʽ jdbc:mysql://����IP:�˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.220.200:3306/db1";
		String user="root";
		String password="123456";
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			//ѡ��Ҫ���������ݿ�����------�������������䣩
			Class.forName("com.mysql.jdbc.Driver");
			
			//��������  ����IP  �˿ں� �û��� ����  ѡ��Ҫ���������ݿ�
			con = DriverManager.getConnection(url, user, password);
			
			//��������� ��дsql��䣩
			pre = con.prepareStatement("select * from student");
			  
			//����sql��䲢��ѯ��䲢�鿴��� �������ɾ�Ĳ飬�򷵻���Ӱ�������������ǲ�ѯ���ص��ǲ�ѯ���
            //���е�ʱ�� �������ɾ�Ĳ� �����cuteUpdate ����int����Ӱ��������� �����ѯ �����executQuery ����ResultSet������ȥ�صĽ����
			rs=pre.executeQuery();
	        //�鿴�����
			while(rs.next()){
				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pre!=null)
				    pre.close();
				if(con!=null)
				    con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		    }
		}
	}
}
