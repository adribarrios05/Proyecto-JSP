package views;

import users.User;

public class navbarView {
    private User user;

    public navbarView(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return """
            <header class="navbar sticky-top bg-dark flex-md-nowrap p-0 shadow" data-bs-theme="dark">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white" href="#">Racing</a>
          
            <ul class="navbar-nav flex-row">
              <li class="nav-item text-nowrap">
                <p class="nav-link px-3 text-white">""" + (user != null ? user.getUsername() : "") + """
                </p>
              </li>
            </ul>
            <ul class="navbar-nav flex-row d-md-none">
              <li class="nav-item text-nowrap">
                <button class="nav-link px-3 text-white" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                  <svg class="bi"><use xlink:href="#list"/></svg>
                </button>
              </li>
            </ul>
          </header>
                """;
    }

    
}
