package filtermessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/Message1")
public class Message1 implements Filter {

    /**
     * Default constructor. 
     */
    public Message1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String message = request.getParameter("message1");
		System.out.println("gfctfc"+message);
		System.out.println("Message before filter: " + message);
		
		message = message.replace("Unfiltered", "Filtered");
		request.setAttribute("message1", message);
		PrintWriter out = response.getWriter();
		out.write("<br />Check your console output");
		chain.doFilter(request, response);
		System.out.println("AYE!! Assignment 15.4 is successfully completed.");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}