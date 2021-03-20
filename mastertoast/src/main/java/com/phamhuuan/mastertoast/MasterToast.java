package com.phamhuuan.mastertoast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MasterToast extends Toast {
	public static final int SUCCESS = 1;
	public static final int WARNING = 2;
	public static final int ERROR = 3;
	public static final int INFO = 4;
	public static final int DEFAULT = 5;
	public static final int CONFUSING = 6;

	public static final int DEFAULT_ICON = -1;
	public static final int NO_ICON = -2;

	/**
	 * Construct an empty Toast object.  You must call {@link #setView} before you
	 * can call {@link #show}.
	 *
	 * @param context The context to use.  Usually your {@link Application}
	 *                or {@link Activity} object.
	 */
	public MasterToast(Context context) {
		super(context);
	}

	/**
	 *
	 * @param context context
	 * @param message type your message
	 * @param duration Toast.LENGTH_LONG | Toast.SHORT_LONG
	 * @param type enum CustomToast.SUCCESS CustomToast.WARNING CustomToast.ERROR CustomToast.INFO CustomToast.DEFAULT CustomToast.CONFUSING
	 * @return toast
	 */
	public static MasterToast makeCustomText(Context context, CharSequence message, int duration, int type) {
		MasterToast toast = new MasterToast(context);
		toast.setDuration(duration);
		View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null, false);
		TextView l1 = layout.findViewById(R.id.toast_text);
		LinearLayout linearLayout = layout.findViewById(R.id.toast_type);
		ImageView img = layout.findViewById(R.id.toast_icon);
		ImageView img1 = layout.findViewById(R.id.right_icon);
		ImageView img2 = layout.findViewById(R.id.delete_icon);
		img2.setVisibility(View.GONE);
		l1.setText(message);
		img1.setVisibility(View.GONE);
		img.setVisibility(View.GONE);
		switch (type) {
			case SUCCESS:
				linearLayout.setBackgroundResource(R.drawable.success_shape);
				break;
			case WARNING:
				linearLayout.setBackgroundResource(R.drawable.warning_shape);
				break;
			case ERROR:
				linearLayout.setBackgroundResource(R.drawable.error_shape);
				break;
			case INFO:
				linearLayout.setBackgroundResource(R.drawable.info_shape);
				break;
			case DEFAULT:
				linearLayout.setBackgroundResource(R.drawable.default_shape);
				break;
			case CONFUSING:
				linearLayout.setBackgroundResource(R.drawable.confuse_shape);
				break;
		}
		toast.setView(layout);
		return toast;
	}

	/**
	 *
	 * @param context context
	 * @param message type your message
	 * @param duration Toast.LENGTH_LONG | Toast.SHORT_LONG
	 * @param type enum CustomToast.SUCCESS CustomToast.WARNING CustomToast.ERROR CustomToast.INFO CustomToast.DEFAULT CustomToast.CONFUSING
	 * @param rightIcon @Nullable null if do not need icon
	 * @param leftIcon customize left icon
	 * @param deleteIcon delete icon
	 * @return toast
	 */
	public static MasterToast makeCustomText(Context context, CharSequence message, int duration, int type, int rightIcon, int leftIcon, int deleteIcon) {
		MasterToast toast = new MasterToast(context);
		toast.setDuration(duration);
		View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null, false);
		TextView l1 = layout.findViewById(R.id.toast_text);
		LinearLayout linearLayout = layout.findViewById(R.id.toast_type);
		ImageView img = layout.findViewById(R.id.toast_icon);
		ImageView img1 = layout.findViewById(R.id.right_icon);
		ImageView img2 = layout.findViewById(R.id.delete_icon);
		l1.setText(message);
		if (rightIcon < 0) {
			img1.setVisibility(View.GONE);
		} else {
			img1.setImageResource(rightIcon);
			img1.setVisibility(View.VISIBLE);
		}
		if (leftIcon <= NO_ICON) {
			img.setVisibility(View.GONE);
		} else if (leftIcon == DEFAULT_ICON) {
			img.setVisibility(View.VISIBLE);
			if (type == SUCCESS) img.setImageResource(R.drawable.ic_check_black_24dp);
			if (type == WARNING) img.setImageResource(R.drawable.ic_pan_tool_black_24dp);
			if (type == ERROR) img.setImageResource(R.drawable.ic_clear_black_24dp);
			if (type == INFO) img.setImageResource(R.drawable.ic_info_outline_black_24dp);
			if (type == CONFUSING) img.setImageResource(R.drawable.ic_refresh_black_24dp);
		} else {
			img.setVisibility(View.VISIBLE);
			img.setImageResource(leftIcon);
		}
		if (deleteIcon <= NO_ICON) {
			img2.setVisibility(View.GONE);
		} else if (deleteIcon == DEFAULT_ICON) {
			img2.setVisibility(View.VISIBLE);
			img2.setImageResource(R.drawable.ic_clear_black_24dp);
		} else {
			img2.setImageResource(deleteIcon);
		}
		img2.setOnClickListener(v -> {
			Log.d("Click delete", "Hi");
			toast.cancel();
		});
		switch (type) {
			case SUCCESS:
				linearLayout.setBackgroundResource(R.drawable.success_shape);
				break;
			case WARNING:
				linearLayout.setBackgroundResource(R.drawable.warning_shape);
				break;
			case ERROR:
				linearLayout.setBackgroundResource(R.drawable.error_shape);
				break;
			case INFO:
				linearLayout.setBackgroundResource(R.drawable.info_shape);
				break;
			case DEFAULT:
				linearLayout.setBackgroundResource(R.drawable.default_shape);
				img.setVisibility(View.GONE);
				break;
			case CONFUSING:
				linearLayout.setBackgroundResource(R.drawable.confuse_shape);
				break;
		}
		toast.setView(layout);
		return toast;
	}
}
