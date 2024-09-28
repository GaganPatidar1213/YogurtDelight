package js;


import java.util.ArrayList;
import java.util.List;

public class MobileNavigation {
    private static boolean isNavigationDisplayed = false;
    private List<MenuItem> menuItems = new ArrayList<>();

    public void onload() {
        MenuItem navigation = new MenuItem("navigation");
        MenuItem mobileNavigation = new MenuItem("mobile-navigation");
        mobileNavigation.addEventListener(new MobileNavigationClickListener());

        navigation.addSubmenu(new MenuItem("submenu1"));
        navigation.addSubmenu(new MenuItem("submenu2"));
        // Add more submenus if needed

        menuItems.add(navigation);
        menuItems.add(mobileNavigation);
    }

    private static void toggleNavigation() {
        isNavigationDisplayed = !isNavigationDisplayed;
        if (isNavigationDisplayed) {
            System.out.println("Navigation displayed");
            // Code to show navigation
        } else {
            System.out.println("Navigation hidden");
            // Code to hide navigation
        }
    }

    private void toggleSubmenu(int index) {
        MenuItem item = menuItems.get(index);
        item.toggleSubmenu();
    }

    public static void main(String[] args) {
        MobileNavigation mobileNav = new MobileNavigation();
        mobileNav.onload();

        // Simulate clicking on mobile navigation
        mobileNav.menuItems.get(1).click();

        // Simulate clicking on a submenu
        mobileNav.toggleSubmenu(0);
    }

    private static class MenuItem {
        private String id;
        private boolean isSubmenuVisible = false;

        public MenuItem(String id) {
            this.id = id;
        }

        public void addSubmenu(MenuItem submenu) {
            // Add submenu item
        }

        public void toggleSubmenu() {
            isSubmenuVisible = !isSubmenuVisible;
            if (isSubmenuVisible) {
                System.out.println("Submenu displayed for " + id);
                // Code to show submenu
            } else {
                System.out.println("Submenu hidden for " + id);
                // Code to hide submenu
            }
        }

        public void addEventListener(MobileNavigationClickListener listener) {
            // Add event listener
        }

        public void click() {
            // Simulate click
        }
    }

    private static class MobileNavigationClickListener {
        public void onClick() {
            // Simulate click event
            System.out.println("Mobile navigation clicked");
            toggleNavigation();
        }
    }
}
