package c0;

import android.widget.ListView;

/* renamed from: c0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0895f extends AbstractViewOnTouchListenerC0890a {

    /* renamed from: D, reason: collision with root package name */
    public final ListView f13856D;

    public C0895f(ListView listView) {
        super(listView);
        this.f13856D = listView;
    }

    @Override // c0.AbstractViewOnTouchListenerC0890a
    public boolean a(int i7) {
        return false;
    }

    @Override // c0.AbstractViewOnTouchListenerC0890a
    public boolean b(int i7) {
        ListView listView = this.f13856D;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i8 = firstVisiblePosition + childCount;
        if (i7 > 0) {
            if (i8 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i7 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // c0.AbstractViewOnTouchListenerC0890a
    public void j(int i7, int i8) {
        this.f13856D.scrollListBy(i8);
    }
}
