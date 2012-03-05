/**
 * 
 */
package br.com.centergames.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author deivid
 *
 */
public class Connect extends DriverManagerDataSource{
	
	public Connect(){
		setDriverClassName("com.mysql.jdbc.Driver");
		setUrl("jdbc:mysql://localhost:3306/centergames");
		setUsername("centergames");
		setPassword("centergames");
	}
		
}
