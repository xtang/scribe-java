package org.scribe.builder.api;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;

/**
 * QWeibo OAuth 2.0 api.
 **/
public class QWeiboApi20 extends DefaultApi20
{

  private static final String AUTHORIZE_URL = "https://open.t.qq.com/cgi-bin/oauth2/authorize?client_id=%s&response_type=code&redirect_uri=%s";
  private static final String ACCESS_TOKEN_URL = "https://open.t.qq.com/cgi-bin/oauth2/access_token?grant_type=authorization_code";

  @Override
  public String getAccessTokenEndpoint()
  {
    return ACCESS_TOKEN_URL;
  }

  @Override
  public String getAuthorizationUrl(OAuthConfig config)
  {
    return String.format(AUTHORIZE_URL, config.getApiKey(), OAuthEncoder.encode(config.getCallback()));
  }
}
