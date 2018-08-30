package com.wellcom.logger;

import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

//import com.wellcom.sivale.matchonline.hibernate.HibernateSessionFactory;
//import com.wellcom.sivale.matchonline.hibernate.TblLogVisor;
//import com.wellcom.sivale.matchonline.hibernate.TblUsrUsuario;
//import com.wellcom.sivale.matchonline.hibernate.TblUsrUsuarioDAO;


public class JDBCHandler extends Handler {

	private String usuarioId="";
	
	public JDBCHandler() {
		
		super();
		// TODO Auto-generated constructor stub
//		HibernateSessionFactory.getSession();
		usuarioId="";
	}

	
public JDBCHandler(String usuarioId) {
		
		super();
		// TODO Auto-generated constructor stub
//		HibernateSessionFactory.getSession();
		this.usuarioId=usuarioId;
	}

	@Override
	public void close() throws SecurityException {
		
	}

	@Override
	public void flush() {

	}

	@Override
	public void publish(LogRecord record) {
		if ( getFilter()!=null ) {
		      if ( !getFilter().isLoggable(record) )
		        return;
		    }
/*		TblLogVisor logVisor=new TblLogVisor();
		logVisor.setLogVisorId(new Date().getTime());
		logVisor.setTipoEventoUid(record.getLevel().toString());
		logVisor.setFechaSistema(new Date(record.getMillis()));
		logVisor.setAplicacionUid(record.getSourceClassName());
		logVisor.setModuloUid(record.getSourceMethodName());
		logVisor.setMensaje(record.getMessage());
		if(!this.usuarioId.equals("")){
			TblUsrUsuarioDAO usuarioDAO=new TblUsrUsuarioDAO();
			TblUsrUsuario usuario= usuarioDAO.findById(Long.parseLong(usuarioId));
			logVisor.setTblUsrUsuario(usuario);
			logVisor.setUsuarioUid(usuario.getUsuarioUid());
		}
		logVisor.save();
*/
	}

}
