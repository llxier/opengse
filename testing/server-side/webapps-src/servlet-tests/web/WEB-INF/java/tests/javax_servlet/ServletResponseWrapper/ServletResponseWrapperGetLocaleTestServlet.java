/*
 * $Header: /home/cvs/jakarta-watchdog-4.0/src/server/servlet-tests/WEB-INF/classes/tests/javax_servlet/ServletResponseWrapper/ServletResponseWrapperGetLocaleTestServlet.java,v 1.1 2002/01/11 22:21:00 rlubke Exp $ 
 * $Revision: 1.1 $
 * $Date: 2002/01/11 22:21:00 $
 *
 * ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999-2002 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package tests.javax_servlet.ServletResponseWrapper;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import common.util.StaticLog;
import java.util.Enumeration;

public class ServletResponseWrapperGetLocaleTestServlet extends GenericServlet {

    StaticLog sl = new StaticLog();

    public void service ( ServletRequest request, ServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        sl.resetLog();

        Locale expectedResult = new Locale( "en", "US" );
        response.setLocale( expectedResult );
        Locale result = response.getLocale();

        if ( result.equals( expectedResult ) ) {
            out.println( "ServletResponseWrapperGetLocaleTest test PASSED<BR>" );
        } else {
            out.println( "ServletResponseWrapperGetLocaleTest test FAILED<BR>" );
            out.println( "    ServletResponseWrapper.getLocale() did not receive the proper locale<BR>" );
            out.println( "    Expected result = " + expectedResult.getLanguage() + "-" + expectedResult.getCountry() + " <BR>" );
            out.println( "    Actual result = |" + result.getLanguage() + "-" + result.getCountry() + "|<BR>" );
        }

        Enumeration e = sl.readFromLog();

        while ( e.hasMoreElements() ) {
            String tmp = ( String ) e.nextElement();
            out.println( tmp );
        }
    }
}
