
package application;

import java.sql.Connection;


public interface Connectable {
    
    public Connection getConnection();
}
