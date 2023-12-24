package by.clevertec.klimov.cleverbank.command;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SessionResponseContent {

  public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
  public static final String CHARSET_UTF_8 = "UTF-8";
  private final HttpServletResponse response;
  private final Gson gson = new Gson();

  public <T> void prepareResponse(List<T> objects) throws IOException {
    int httpServletResponse;
    if (objects.isEmpty()) {
      httpServletResponse = HttpServletResponse.SC_NOT_FOUND;
    } else {
      PrintWriter out = response.getWriter();
      response.setContentType(CONTENT_TYPE_APPLICATION_JSON);
      response.setCharacterEncoding(CHARSET_UTF_8);
      out.print(gson.toJson(objects));
      out.flush();
      httpServletResponse = HttpServletResponse.SC_OK;
    }
    response.setStatus(httpServletResponse);
  }

  public <T> void prepareResponse(T object) throws IOException {
    int httpServletResponse;
    if (Objects.isNull(object)) {
      httpServletResponse = HttpServletResponse.SC_NOT_FOUND;
    } else {
      PrintWriter out = response.getWriter();
      response.setContentType(CONTENT_TYPE_APPLICATION_JSON);
      response.setCharacterEncoding(CHARSET_UTF_8);
      out.print(gson.toJson(object));
      out.flush();
      httpServletResponse = HttpServletResponse.SC_OK;
    }
    response.setStatus(httpServletResponse);
  }
}
