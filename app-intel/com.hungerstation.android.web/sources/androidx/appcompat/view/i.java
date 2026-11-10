package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* loaded from: classes.dex */
public class i implements Window.Callback {

    /* renamed from: b, reason: collision with root package name */
    final Window.Callback f2245b;

    /* loaded from: classes6.dex */
    static class a {
        static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i12) {
            return callback.onWindowStartingActionMode(callback2, i12);
        }
    }

    /* loaded from: classes6.dex */
    static class b {
        static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i12) {
            callback.onProvideKeyboardShortcuts(list, menu, i12);
        }
    }

    /* loaded from: classes6.dex */
    static class c {
        static void a(Window.Callback callback, boolean z12) {
            callback.onPointerCaptureChanged(z12);
        }
    }

    public i(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f2245b = callback;
    }

    public final Window.Callback a() {
        return this.f2245b;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f2245b.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2245b.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f2245b.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f2245b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f2245b.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f2245b.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f2245b.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f2245b.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f2245b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i12, Menu menu) {
        return this.f2245b.onCreatePanelMenu(i12, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i12) {
        return this.f2245b.onCreatePanelView(i12);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f2245b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i12, MenuItem menuItem) {
        return this.f2245b.onMenuItemSelected(i12, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i12, Menu menu) {
        return this.f2245b.onMenuOpened(i12, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i12, Menu menu) {
        this.f2245b.onPanelClosed(i12, menu);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z12) {
        c.a(this.f2245b, z12);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i12, View view, Menu menu) {
        return this.f2245b.onPreparePanel(i12, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i12) {
        b.a(this.f2245b, list, menu, i12);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f2245b, searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f2245b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z12) {
        this.f2245b.onWindowFocusChanged(z12);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f2245b.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f2245b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i12) {
        return a.b(this.f2245b, callback, i12);
    }
}
