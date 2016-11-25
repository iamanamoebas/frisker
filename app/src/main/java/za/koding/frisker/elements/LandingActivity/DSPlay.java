package za.koding.frisker.elements.LandingActivity;

import android.graphics.Canvas;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.util.AttributeSet;
import za.koding.frisker.R;
import za.koding.frisker.lib.DropsourceVaried;
import za.koding.frisker.elements.LandingActivity.DSViews;
import android.support.percent.PercentRelativeLayout;

/**
 * The custom element class for DSPlay which extends
 * {@link android.support.percent.PercentRelativeLayout}.
 * This element's parent page is {@link za.koding.frisker.activities.LandingActivity},
 * and its parent element is {@link za.koding.frisker.elements.LandingActivity.DSViews}.
 * This element has 4 properties: opacity, backgroundColor, hidden,
 * enabled; and 1 children: {@link za.koding.frisker.elements.LandingActivity.DSFlappy}.
 */
public class DSPlay extends PercentRelativeLayout implements DropsourceVaried {
  /**
   * This element's current variant
   */
  private String variant;

  /**
   * {@link #DSPlay(Context, AttributeSet)}
   */
  public DSPlay(Context context) {
    this(context, null);
  }

  /**
   * {@link #DSPlay(Context, AttributeSet, int)}
   */
  public DSPlay(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  /**
   * {@link PercentRelativeLayout#PercentRelativeLayout(Context, AttributeSet, int)}
   *
   * @param context The Context the view is running in, through which it can access the current
   *                theme, resources, etc.
   * @param attrs The attributes of the XML tag that is inflating the view.
   * @param defStyleAttr An attribute in the current theme that contains a reference to a style resource
   *                     that supplies default values for the view. Can be 0 to not look for defaults.
   *
   */
  public DSPlay(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    this.variant = "Default";

    this.setId(R.id.play);
  }

  /**
   * {@link android.support.percent.PercentRelativeLayout#onAttachedToWindow()}
   */
  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    this.synchronizeStyle();
  }

  /**
   * {@link android.support.percent.PercentRelativeLayout#onDraw(Canvas)}
   */
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
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
        {}
        break;
    }
  }

  /**
   * Retrieves the parent {@link DSViews} of this element.
   *
   * @return the parent {@link DSViews}
   */
  public DSViews _getParent() {
    return (DSViews) getParent();
  }

  /**
   * This element's child flappy.
   */
  public DSFlappy _getFlappy() {
    return (DSFlappy) this.findViewById(R.id.flappy);
  }
}