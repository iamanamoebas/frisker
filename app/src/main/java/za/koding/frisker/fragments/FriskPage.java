package za.koding.frisker.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import za.koding.frisker.R;
import za.koding.frisker.elements.LandingActivity.DSViews;
import za.koding.frisker.elements.LandingActivity.DSFrisk;

/**
 * The custom Fragment for frisk. This Fragment has a corresponding Element
 * {@link za.koding.frisker.elements.LandingActivity.DSFrisk}.
 */
public class FriskPage extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
    super.onCreateView(inflater, container, bundle);

    View view = inflater.inflate(R.layout.frisk_page, container, false);

    return view;
  }
}