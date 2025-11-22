package String;

public class DefangIPaddr {
    public String defangIPaddr1(String address) {
        return address.replace("." , "[.]");
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
