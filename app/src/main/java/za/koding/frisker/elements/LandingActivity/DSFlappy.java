package za.koding.frisker.elements.LandingActivity;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.util.AttributeSet;
import za.koding.frisker.R;
import za.koding.frisker.lib.DropsourceVaried;
import za.koding.frisker.elements.LandingActivity.DSPlay;
import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import android.webkit.URLUtil;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

/**
 * The custom element class for DSFlappy which extends
 * {@link android.webkit.WebView}. This element's parent page is
 * {@link za.koding.frisker.activities.LandingActivity},
 * and its parent element is {@link za.koding.frisker.elements.LandingActivity.DSPlay}.
 * This element has 9 properties: backgroundColor, url, enabled, hidden,
 * javascriptEnabled, zoomEnabled, overviewModeEnabled, opacity,
 * wideViewportEnabled.
 */
public class DSFlappy extends WebView implements DropsourceVaried {
  /**
   * This element's current variant
   */
  private String variant;

  /**
   * {@link #DSFlappy(Context, AttributeSet)}
   */
  public DSFlappy(Context context) {
    this(context, null);
  }

  /**
   * {@link #DSFlappy(Context, AttributeSet, int)}
   */
  public DSFlappy(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  /**
   * {@link WebView#WebView(Context, AttributeSet, int)}
   *
   * @param context The Context the view is running in, through which it can access the current
   *                theme, resources, etc.
   * @param attrs The attributes of the XML tag that is inflating the view.
   * @param defStyleAttr An attribute in the current theme that contains a reference to a style resource
   *                     that supplies default values for the view. Can be 0 to not look for defaults.
   *
   */
  public DSFlappy(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    this.variant = "Default";

    this.setId(R.id.flappy);

    this.setWebViewClient(
        new WebViewClient() {
          @Override
          public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (URLUtil.isNetworkUrl(url)) {
              return false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            _getParent()._getParent()._getParent().startActivity(intent);
            return true;
          }

          @Override
          public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
          }

          @Override
          public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
          }

          @Override
          public void onReceivedError(
              WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
          }
        });

    this.loadUrl("http://play.audiogear.mobi");
  }

  /**
   * {@link android.webkit.WebView#onAttachedToWindow()}
   */
  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    this.synchronizeStyle();
  }

  /**
   * {@link DropsourceVaried#setVariant(String)}
   *
   * @param name {@link #variant}
   */
  public void setVariant(String name) {
    this.variant = name;

    synchronizeStyle();
  }

  /**
   * {@link DropsourceVaried#setState(String)}
   *
   * @param name N/A
   */
  public void setState(String name) {}

  /**
   * {@link DropsourceVaried#getState()}
   *
   * @return null
   */
  public String getState() {
    return null;
  }

  /**
   * {@link DropsourceVaried#getVariant()}
   *
   * @return {@link #variant}
   */
  public String getVariant() {
    return this.variant;
  }

  /**
   * {@link DropsourceVaried#synchronizeStyle()}
   */
  public void synchronizeStyle() {
    switch (variant) {
      case "Default":
        {
          this.getSettings().setUseWideViewPort(true);
          this.getSettings().setLoadWithOverviewMode(false);
          this.getSettings().setSupportZoom(false);
          this.getSettings().setJavaScriptEnabled(true);
          this.getSettings().setAllowFileAccess(false);
        }
        break;
    }
  }

  /**
   * Retrieves the parent {@link DSPlay} of this element.
   *
   * @return the parent {@link DSPlay}
   */
  public DSPlay _getParent() {
    return (DSPlay) getParent();
  }
}