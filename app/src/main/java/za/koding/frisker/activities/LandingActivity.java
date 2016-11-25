package za.koding.frisker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;
import za.koding.frisker.lib.DropsourceVaried;
import za.koding.frisker.R;
import android.widget.ImageView;
import android.view.Window;
import android.view.WindowManager;
import za.koding.frisker.elements.LandingActivity.*;
import za.koding.frisker.dataModels.*;

/**
 * The Activity for the page: Landing. This page has the following elements: views;
 * and the following components: .
 */
public class LandingActivity extends AppCompatActivity implements DropsourceVaried {
  /**
   * This page's layout container
   */
  LinearLayout landing;

  /**
   * This page's background ImageView
   */
  ImageView landingBackground;

  /**
   * This page's current variant
   */
  private String variant;

  /**
   * {@link android.support.v4.app.FragmentActivity#onCreate(Bundle savedInstanceState)}
   * Will also disable the status bar, since no status bar component included.
   *
   * @param savedInstanceState If the activity is being re-initialized after previously being shut down then
   *                           this Bundle contains the data it most recently supplied in
   *                           {@link #onSaveInstanceState}. <b><i>Note: Otherwise it is null.</i></b>
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);

    this.getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.landing);

    this.variant = "Default";

    landingBackground = (ImageView) findViewById(R.id.landing_background);

    landing = (LinearLayout) findViewById(R.id.landing);

    this.synchronizeStyle();
  }

  /**
   * {@link android.support.v4.app.FragmentActivity#onResume()}
   */
  @Override
  protected void onResume() {
    super.onResume();
  }

  /**
   * {@link android.support.v4.app.FragmentActivity#onStop()}
   */
  @Override
  protected void onStop() {
    super.onStop();
  }

  /**
   * Returns "this", to allow for and consistent method by which the current context
   * is accessed.
   */
  public LandingActivity getContext() {
    return this;
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
   * @return null since a page does not have a state
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
    switch (this.variant) {
      case "Default":
        {
          landing.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.HEX_FF0000AF));
          landingBackground.setImageDrawable(
              ContextCompat.getDrawable(getContext(), R.drawable.logo_gam3newz_400x400));
          landingBackground.setScaleType(ImageView.ScaleType.CENTER);
        }
        break;
    }
  }

  /**
   * This page's child views.
   */
  public DSViews _getViews() {
    return (DSViews) this.findViewById(R.id.views);
  }
}