package id.co.next_innovation.leaseapp.ui.help;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.widget.LinearLayout;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.JustifiedSpan;
import com.bluejamesbond.text.style.LeftSpan;
import com.bluejamesbond.text.style.TextAlignment;
import com.bluejamesbond.text.util.ArticleBuilder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.ui.base.BaseActivity;
import id.co.next_innovation.leaseapp.ui.helper.QuoteSpan;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HelpActivity extends BaseActivity implements HelpView {

    @Inject
    HelpMvpPresenter<HelpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getActivityComponent().inject(this);
        overridePendingTransition(R.anim.anim_pop_up, R.anim.anim_push_up);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {

        ArticleBuilder amb = new ArticleBuilder();

        amb.append(getString(R.string.howto), false, new RelativeSizeSpan(2f), new StyleSpan(Typeface.BOLD),
                new LeftSpan());
        amb.append("<font color=0xFFC801>"+getString(R.string.import_data) +"</font><font color=0x888888></font>",
                true, new RelativeSizeSpan(0.8f), new StyleSpan(Typeface.BOLD));
        amb.append(
                "Import data " +
                        " dapat dilakukan melalui admin panel / android app.",
                true, new RelativeSizeSpan(1.0f), new JustifiedSpan(), new QuoteSpan(0xFFFFC801),
                new StyleSpan(Typeface.ITALIC), new ForegroundColorSpan(0xFF555555));

        amb.append("<font color=0xFFC801>"+getString(R.string.import_data_caps)+"</font>\n", true, new RelativeSizeSpan(1.2f), new JustifiedSpan());
        amb.append("1. Pastikan file excel bertype csv dan sesuai template.\n", true, new RelativeSizeSpan(1.2f), new JustifiedSpan());
        amb.append("2. Pastikan internet anda dalam keadaan stabil (4G/Wifi/Other).\n", true, new RelativeSizeSpan(1.2f), new JustifiedSpan());
        amb.append("3. Import melalui fitur import / melalui website.\n", true, new RelativeSizeSpan(1.2f), new JustifiedSpan());


//        amb.append("<font color=0xFFC801>Library</font>\n", true, new RelativeSizeSpan(1.0f), new JustifiedSpan());
//        amb.append("1. <font color=0xFFC801>RxJava2</font> https://github.com/ReactiveX/RxJava\n", true, new RelativeSizeSpan(1.0f), new JustifiedSpan());
//        amb.append("2. <font color=0xFFC801>Dagger2</font> https://google.github.io/dagger/\n", true, new RelativeSizeSpan(1.0f), new JustifiedSpan());
//        amb.append("3. <font color=0xFFC801>ButterKnife</font> http://jakewharton.github.io/butterknife/\n", true, new RelativeSizeSpan(1.0f), new JustifiedSpan());
//        amb.append("4. <font color=0xFFC801>Text Justify</font> https://github.com/bluejamesbond/TextJustify-Android\n", true, new RelativeSizeSpan(1.0f), new JustifiedSpan());
//        amb.append("5. <font color=0xFFC801>Better Pickers</font> https://github.com/code-troopers/android-betterpickers\n", true, new RelativeSizeSpan(1.0f), new JustifiedSpan());

        addDocumentView(amb, DocumentView.FORMATTED_TEXT);

    }

    public DocumentView addDocumentView(CharSequence article, int type, boolean rtl) {
        final DocumentView documentView = new DocumentView(this, type);
        documentView.getDocumentLayoutParams().setTextColor(0xffffffff);
        documentView.getDocumentLayoutParams().setTextTypeface(Typeface.DEFAULT);
        documentView.getDocumentLayoutParams().setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView.getDocumentLayoutParams().setInsetPaddingLeft(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingRight(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingTop(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingBottom(30f);
        documentView.getDocumentLayoutParams().setLineHeightMultiplier(1f);
        documentView.getDocumentLayoutParams().setReverse(rtl);
        documentView.setText(article);
        documentView.setFadeInDuration(800);
        documentView.setFadeInAnimationStepDelay(30);
        documentView.setFadeInTween((t, b, c, d) -> c * (t /= d) * t * t + b);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.addView(documentView);

        LinearLayout articleList = (LinearLayout) findViewById(R.id.articleList);
        articleList.addView(linearLayout);


        return documentView;
    }

    public DocumentView addDocumentView(CharSequence article, int type) {
        return addDocumentView(article, type, false);

    }

    private void finishAction() {
        finish();
        overridePendingTransition(R.anim.anim_pop_down, R.anim.anim_push_down);
    }

    public void onBackPressed() {
        finishAction();
    }
}