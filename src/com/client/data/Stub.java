package com.client.data;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

public final class Stub
  implements AppletStub
{
  private Hashtable<String, String> a = new Hashtable<String, String>();
  
  public Stub()
  {
    this.a.put("worldid", "1");
    this.a.put("portoff", "0");
    this.a.put("version", "474");
   
  }
  
  public final String getParameter(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  public final URL getDocumentBase()
  {
    return getCodeBase();
  }
  
  public final URL getCodeBase()
  {
    try
    {
      return new URL("http://www.soulsplit3.com");
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException();
    }
  }
  
  public final void appletResize(int paramInt1, int paramInt2) {}
  
  public final AppletContext getAppletContext()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}
