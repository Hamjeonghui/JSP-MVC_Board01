package controller.action;

public class ActionForward {
	private String path;
	private boolean redirect;
	
	public String getPath() {
		return path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}