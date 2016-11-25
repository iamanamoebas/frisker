package za.koding.frisker.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import za.koding.frisker.R;
import za.koding.frisker.elements.LandingActivity.DSViews;
import za.koding.frisker.elements.LandingActivity.DSPlay;

/**
 * The custom Fragment for play. This Fragment has a corresponding Element
 * {@link za.koding.frisker.elements.LandingActivity.DSPlay}.
 */
public class PlayPage extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
    super.onCreateView(inflater, container, bundle);

    View view = inflater.inflate(R.layout.play_page, container, false);

    return view;
  }
}