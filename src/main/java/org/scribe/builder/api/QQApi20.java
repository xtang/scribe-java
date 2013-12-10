package org.scribe.builder.api;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;

/**
 * QQ OAuth 2.0 api: http://wiki.connect.qq.com/
 **/
public class QQApi20 extends DefaultApi20
{
  private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize?client_id=%s&response_type=code&redirect_uri=%s&state=prod";
  private static final String ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&state=prod";
  private static final String SCOPED_AUTHORIZE_URL = AUTHORIZE_URL + "&scope=%s";

  @Override
  public String getAccessTokenEndpoint()
  {
    return ACCESS_TOKEN_URL;
  }

  @Override
  public String getAuthorizationUrl(OAuthConfig config)
  {
    if (config.hasScope())
    {
        return String.format(SCOPED_AUTHORIZE_URL, config.getApiKey(), OAuthEncoder.encode(config.getCallback()), OAuthEncoder.encode(config.getScope()));
    }
    else
    {
        return String.format(AUTHORIZE_URL, config.getApiKey(), OAuthEncoder.encode(config.getCallback()));
    }
  }
}
