package dad.login.MVC;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

    private StringProperty usuario = new SimpleStringProperty();
    private StringProperty contrasena = new SimpleStringProperty();
    private StringProperty ldap = new SimpleStringProperty();

    public String getLdap() {
        return ldap.get();
    }

    public StringProperty ldapProperty() {
        return ldap;
    }

    public void setLdap(String ldap) {
        this.ldap.set(ldap);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getContrasena() {
        return contrasena.get();
    }

    public StringProperty contrasenaProperty() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena.set(contrasena);
    }
}
