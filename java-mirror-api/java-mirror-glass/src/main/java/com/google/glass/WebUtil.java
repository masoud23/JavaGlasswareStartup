/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.google.glass;

import com.google.api.client.http.GenericUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Masoud
 */
public class WebUtil {
  /**
   * Builds a URL relative to this app's root.
   */
  public static String buildUrl(HttpServletRequest req, String relativePath) {
    GenericUrl url = new GenericUrl(req.getRequestURL().toString());
    url.setRawPath(relativePath);
    return url.build();
  }

  /**
   * A simple flash implementation for text messages across requests
   *
   * @param request
   * @return
   */
  public static String getClearFlash(HttpServletRequest request) {
    HttpSession session = request.getSession();
    String flash = (String) session.getAttribute("flash");
    session.removeAttribute("flash");
    return flash;
  }

  public static void setFlash(HttpServletRequest request, String flash) {
    HttpSession session = request.getSession();
    session.setAttribute("flash", flash);
  }
}
