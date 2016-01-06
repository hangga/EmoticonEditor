package com.hangga.emot;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String KODE_SMILLE = "[:)]";
	private static final String KODE_SWEET = "[:3]";
	private static final String KODE_SURPRISE = "[:/]";
	private static final String KODE_SPOOK = "[:(]";
	private static final String KODE_SHOUT = "[:8]";
	private static final String KODE_MIAO = "[:9]";
	private static final String KODE_LOVE = "[(v)]";
	private static final String KODE_COOL = "[::]";
	private static final String KODE_FIRE = "[==]";
	
	/*private static final String KODE_SMILLE = ".:).";
	private static final String KODE_SWEET = ".:3.";
	private static final String KODE_SURPRISE = ".:/.";
	private static final String KODE_SPOOK = ".:(.";
	private static final String KODE_SHOUT = ".:8.";
	private static final String KODE_MIAO = ".:9.";
	private static final String KODE_LOVE = ".(v).";
	private static final String KODE_COOL = ".::.";
	private static final String KODE_FIRE = ".==.";*/
	
	EditText textPost;
	ImageButton btnEmot;
	Drawable icSmille, icSweet, icSurprise, icSpook, icShout, icMiao, icLove, icCool, icFire;
	
	private EmoticonHandler emoticonHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textPost = (EditText) findViewById(R.id.textPost);
		
		icSmille = getResources().getDrawable(R.drawable.smile);
		icSmille.setBounds(5,5,60,60);
		
		icSweet = getResources().getDrawable(R.drawable.sweat);
		icSweet.setBounds(5,5,60,60);
		
		icSurprise = getResources().getDrawable(R.drawable.surprise);
		icSurprise.setBounds(5,5,60,60);
		
		icSpook = getResources().getDrawable(R.drawable.spook);
		icSpook.setBounds(5,5,60,60);
		
		icShout = getResources().getDrawable(R.drawable.shout);
		icShout.setBounds(5,5,60,60);
		
		icMiao = getResources().getDrawable(R.drawable.miao);
		icMiao.setBounds(5,5,60,60);
		
		icLove = getResources().getDrawable(R.drawable.love);
		icLove.setBounds(5,5,60,60);
		
		icCool = getResources().getDrawable(R.drawable.cool);
		icCool.setBounds(5,5,60,60);
		
		icFire = getResources().getDrawable(R.drawable.fire);
		icFire.setBounds(5,5,60,60);
		
		btnEmot = (ImageButton) findViewById(R.id.btnEmot);
		btnEmot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//emoticonHandler.insert(":)", R.drawable.smile);
				emotDialog();
			}
		});
		
		emoticonHandler = new EmoticonHandler(textPost);
		
		/*textPost.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				Editable buffer = textPost.getText();
			    // If the cursor is at the end of a RecipientSpan then remove the whole span
			    int start = Selection.getSelectionStart(buffer);
			    int end = Selection.getSelectionEnd(buffer);
			    if (start == end) {
			    	ImageSpan[] link = buffer.getSpans(start, end, ImageSpan.class);
			        if (link.length > 0) {
			            buffer.replace(
			                    buffer.getSpanStart(link[0]),
			                    buffer.getSpanEnd(link[0]),
			                    ""
			            );
			            buffer.removeSpan(link[0]);
			        }
			    }
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				emotSpannable(s);
				//emotSpan(s);
			}
		});*/
	}
	
	private void emotDialog(){
		final Dialog dia = new Dialog(this);
		dia.setContentView(R.layout.emot_dialog);
		dia.setTitle("Pick");
		dia.setCancelable(true);
		ImageButton btnSmille = (ImageButton) dia.findViewById(R.id.btnSmille);
		btnSmille.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_SMILLE);
				dia.dismiss();
			}
		});
		
		ImageButton btnSweat = (ImageButton) dia.findViewById(R.id.btnSweat);
		btnSweat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_SWEET);
				dia.dismiss();
			}
		});
		
		ImageButton btnSurprise = (ImageButton) dia.findViewById(R.id.btnSurprise);
		btnSurprise.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_SURPRISE);
				dia.dismiss();
			}
		});
		
		ImageButton btnSpook = (ImageButton) dia.findViewById(R.id.btnSpook);
		btnSpook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_SPOOK);
				dia.dismiss();
			}
		});
		
		ImageButton btnShout = (ImageButton) dia.findViewById(R.id.btnShout);
		btnShout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_SHOUT);
				dia.dismiss();
			}
		});
		
		ImageButton btnFire = (ImageButton) dia.findViewById(R.id.btnFire);
		btnFire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_FIRE);
				dia.dismiss();
			}
		});
		
		ImageButton btnMiao = (ImageButton) dia.findViewById(R.id.btnMiao);
		btnMiao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_MIAO);
				dia.dismiss();
			}
		});
		
		ImageButton btnLove = (ImageButton) dia.findViewById(R.id.btnLove);
		btnLove.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_LOVE);
				dia.dismiss();
			}
		});
		
		ImageButton btnCool = (ImageButton) dia.findViewById(R.id.btnCool);
		btnCool.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InsertKode(KODE_COOL);
				dia.dismiss();
			}
		});
		dia.show();
	}
	
	private void InsertKode(String kode){
		int selectionStart = textPost.getSelectionStart();
        int selectionEnd = textPost.getSelectionEnd();
        String textToInsert = kode;
        textPost.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd),
                textToInsert, 0, textToInsert.length());
	}
	
	private void emotSpannable(Spannable spannable) {
        int length = spannable.length();
        int position = 0;
        int tagStartPosition = 0;
        int tagLength = 0;
        StringBuilder buffer = new StringBuilder();
        boolean inTag = false;

        if(length <= 0)
            return;

        do {
            String c = spannable.subSequence(position, position + 1).toString();

            if (!inTag && c.equals(" ")) {
            	buffer = new StringBuilder();
                tagStartPosition = position;
                inTag = true;
                tagLength = 0;
            }

            if (inTag) {
                buffer.append(c);
                tagLength ++;

                if (c.equals(" ")) {
                    inTag = false;

                    String tag = buffer.toString();
                    int tagEnd = tagStartPosition + tagLength;
                    
                    if (tag.equals(KODE_SMILLE)) {
                        ImageSpan imageSpan = new ImageSpan(icSmille, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    
                    if (tag.equals(KODE_SWEET)) {
                        ImageSpan imageSpan = new ImageSpan(icSweet, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_SURPRISE)) {
                        ImageSpan imageSpan = new ImageSpan(icSurprise, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_SPOOK)) {
                        ImageSpan imageSpan = new ImageSpan(icSpook, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_SHOUT)) {
                        ImageSpan imageSpan = new ImageSpan(icShout, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_MIAO)) {
                        ImageSpan imageSpan = new ImageSpan(icMiao, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_LOVE)) {
                        ImageSpan imageSpan = new ImageSpan(icLove, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_COOL)) {
                        ImageSpan imageSpan = new ImageSpan(icCool, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                    if (tag.equals(KODE_FIRE)) {
                        ImageSpan imageSpan = new ImageSpan(icFire, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(imageSpan, tagStartPosition, tagEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);    // Spannable#setSpan applies the xxxxSpan to characters n1...n2
                    }
                }
            }

            position++;
        } while (position < length);
    }
	
	private static class EmoticonHandler implements TextWatcher {

        private final EditText mEditor;
        private final ArrayList<ImageSpan> mEmoticonsToRemove = new ArrayList<ImageSpan>();

        public EmoticonHandler(EditText editor) {
            // Attach the handler to listen for text changes.
            mEditor = editor;
            mEditor.addTextChangedListener(this);
        }

        public void insert(String emoticon, int resource) {
            // Create the ImageSpan
            Drawable drawable = mEditor.getResources().getDrawable(resource);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);

            // Get the selected text.
            int start = mEditor.getSelectionStart();
            int end = mEditor.getSelectionEnd();
            Editable message = mEditor.getEditableText();

            // Insert the emoticon.
            message.replace(start, end, emoticon);
            message.setSpan(span, start, start + emoticon.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        @Override
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            // Check if some text will be removed.
            /*if (count > 0) {
                int end = start + count;
                Editable message = mEditor.getEditableText();
                ImageSpan[] list = message.getSpans(start, end, ImageSpan.class);

                for (ImageSpan span : list) {
                    // Get only the emoticons that are inside of the changed
                    // region.
                    int spanStart = message.getSpanStart(span);
                    int spanEnd = message.getSpanEnd(span);
                    if ((spanStart < end) && (spanEnd > start)) {
                        // Add to remove list
                        mEmoticonsToRemove.add(span);
                    }
                }
            }*/
        }

        @Override
        public void afterTextChanged(Editable text) {
            /*Editable message = mEditor.getEditableText();

            // Commit the emoticons to be removed.
            for (ImageSpan span : mEmoticonsToRemove) {
                int start = message.getSpanStart(span);
                int end = message.getSpanEnd(span);

                // Remove the span
                message.removeSpan(span);

                // Remove the remaining emoticon text.
                if (start != end) {
                    message.delete(start, end);
                }
            }
            mEmoticonsToRemove.clear();*/

        }

        @Override
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }

    }
}
