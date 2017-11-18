package controllers;

import javax.inject.Inject;

import java.sql.Statement;
import java.sql.ResultSet;

import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MimeTypes;

public class HomeController extends Controller {

    final private Database db;

    @Inject
    public HomeController(final Database db) {
        this.db = db;
    }

    public Result index() {
        return db.withConnection(connection -> {
            final StringBuilder sb = new StringBuilder();
            sb.append("Following evolutions have been applied:\n");
            sb.append("---------------------------------------\n");
            try(final Statement stmt = connection.createStatement()) {
                final ResultSet rs = stmt.executeQuery("SELECT id, filename FROM applied_evolutions_log ORDER BY id");
                while (rs.next()) {
                    sb.append(rs.getString("filename"));
                    sb.append("\n");
                }
            }
            return ok(sb.toString()).as(MimeTypes.TEXT);
        });
    }
}
