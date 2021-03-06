/*
 * This is the source code of Telegram for Android v. 1.7.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2014.
 */

package org.telegram.ui.Cells;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.telegram.android.AndroidUtilities;
import org.telegram.messenger.R;
import org.telegram.ui.Components.LayoutHelper;

public class DrawerActionCell extends FrameLayout {

    private TextView textView;
    protected ImageView badgeView;

    public DrawerActionCell(Context context) {
        super(context);

        textView = new TextView(context);
        textView.setTextColor(0xff444444);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/rmedium.ttf"));
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        textView.setCompoundDrawablePadding(AndroidUtilities.dp(34));
        addView(textView);
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.width = LayoutHelper.MATCH_PARENT;
        layoutParams.height = LayoutHelper.MATCH_PARENT;
        layoutParams.gravity = Gravity.LEFT;
        layoutParams.leftMargin = AndroidUtilities.dp(14);
        layoutParams.rightMargin = AndroidUtilities.dp(16);
        textView.setLayoutParams(layoutParams);

        badgeView = new ImageView(context);
        badgeView.setBackgroundResource(R.drawable.red_badge_bg);
        badgeView.setVisibility(View.INVISIBLE);
        addView(badgeView);
        layoutParams = (LayoutParams) badgeView.getLayoutParams();
        layoutParams.width = AndroidUtilities.dp(10);
        layoutParams.height = AndroidUtilities.dp(10);
        layoutParams.leftMargin = AndroidUtilities.dp(32);
        layoutParams.topMargin = AndroidUtilities.dp(10);
        layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        badgeView.setLayoutParams(layoutParams);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48), MeasureSpec.EXACTLY));
    }

    public void setTextAndIcon(String text, int resId) {
        textView.setText(text);
        textView.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0);
    }

    public void showBadgeView(boolean show) {
        badgeView.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}
