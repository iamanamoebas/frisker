package za.koding.frisker.elements.LandingActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.util.AttributeSet;
import za.koding.frisker.R;
import za.koding.frisker.lib.DropsourceVaried;
import za.koding.frisker.activities.LandingActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.TabLayout;
import za.koding.frisker.fragments.FriskPage;
import za.koding.frisker.fragments.AudioPage;
import za.koding.frisker.fragments.PlayPage;
import android.support.v4.view.ViewPager;

/**
 * The custom element class for DSViews which extends
 * {@link android.support.v4.view.ViewPager}. This element's parent page is
 * {@link za.koding.frisker.activities.LandingActivity}.
 * This element has 13 properties: activeTabIndicatorColor, activeTabColor,
 * backgroundColor, enabled, hidden, tabBarColor, pagerType, tabLayout,
 * views, opacity, indicatorType, visibleView, tabType; and 3 children:
 * {@link za.koding.frisker.elements.LandingActivity.DSFrisk},
 * {@link za.koding.frisker.elements.LandingActivity.DSAudio},
 * {@link za.koding.frisker.elements.LandingActivity.DSPlay}.
 */
public class DSViews extends ViewPager implements DropsourceVaried {
  /**
   * This element's current variant
   */
  private String variant;

  /**
   * The {@link FragmentManager}, used for proper inflation and management of this pager's children
   */
  FragmentManager fragmentManager;

  /**
   * Used in {@link DSViewsPagerAdapter}
   * to allow for quick dereference/referencing when destroying pages
   */
  DSViews self = this;

  /**
   * The {@link TabLayout} which holds the tabs for this pager
   */
  TabLayout tabs;

  /**
   * The title string IDs to be used in each tab in {@link #tabs}
   */
  Integer[] titles;

  /**
   * The {@link DSViewsPagerAdapter} for this pager.
   */
  public DSViewsPagerAdapter adapter;

  /**
   * {@link #DSViews(Context, AttributeSet)}
   */
  public DSViews(Context context) {
    this(context, null);
  }

  /**
   * {@link ViewPager#ViewPager(Context, AttributeSet)}
   *
   * @param context The Context the view is running in, through which it can access the current
   *                theme, resources, etc.
   * @param attrs The attributes of the XML tag that is inflating the view.
   */
  public DSViews(Context context, AttributeSet attrs) {
    super(context, attrs);

    this.setOffscreenPageLimit(2);

    this.variant = "Default";

    this.setId(R.id.views);

    try {
      fragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
    } catch (ClassCastException e) {
      Log.e("DSViews", "Can't get fragment manager");
    }

    adapter = new DSViewsPagerAdapter(fragmentManager);

    this.setAdapter(adapter);

    titles = new Integer[] {R.string.frisk, R.string.audio, R.string.play};
  }

  /**
   * Initializes this pager's {@link #tabs}
   */
  private void setupTabs() {
    for (int i = 0; i < titles.length; i++) {
      if (titles[i] != null && tabs.getTabAt(i) != null) tabs.getTabAt(i).setText(titles[i]);
    }
  }

  /**
   * {@link android.support.v4.view.ViewPager#onAttachedToWindow()}
   */
  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    this.setCurrentItem(0);

    tabs = (TabLayout) (((View) getParent()).findViewById(R.id.views_tabs));

    tabs.setupWithViewPager(this);

    setupTabs();

    this.synchronizeStyle();

    this.addOnPageChangeListener(
        new ViewPager.SimpleOnPageChangeListener() {
          @Override
          public void onPageSelected(int position) {
            switch (position) {
              default:
                break;
            }
          }
        });
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
          tabs.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.HEX_AD0000F3));
          tabs.setSelectedTabIndicatorColor(
              ContextCompat.getColor(getContext(), R.color.HEX_FFFFFFFF));
        }
        break;
    }
  }

  /**
   * Retrieves the parent {@link LandingActivity} of this element.
   *
   * @return the parent {@link LandingActivity}
   */
  public LandingActivity _getParent() {
    Context context = getContext();

    while (context instanceof ContextWrapper) {
      if (context instanceof LandingActivity) {
        return (LandingActivity) context;
      }
      context = ((ContextWrapper) context).getBaseContext();
    }

    return (LandingActivity) context;
  }

  public class DSViewsPagerAdapter extends FragmentPagerAdapter {
    private final int NUM_ITEMS = 3;

    public DSViewsPagerAdapter(FragmentManager fragmentManager) {
      super(fragmentManager);
    }

    @Override
    public int getCount() {
      return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new FriskPage();
        case 1:
          return new AudioPage();
        case 2:
          return new PlayPage();
        default:
          return null;
      }
    }
  }
}