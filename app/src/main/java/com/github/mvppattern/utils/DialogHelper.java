package com.github.mvppattern.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.github.mvppattern.R;

public class DialogHelper {

    public static AlertDialog confirm(Context context, String message,
                                      DialogInterface.OnClickListener yes) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.warning);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.y, yes);
        builder.setNegativeButton(R.string.t, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();

    }

    public static Dialog loading(Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_loading);
        return dialog;

    }

    public interface DialogCallback {
        void onConfirm();

        void onCancel();
    }

}
