public void evaluate(Socket socket) throws IOException {
  try (BufferedReader reader = new BufferedReader(
    new InputStreamReader(socket.getInputStream()))) {
  
    String expression = reader.readLine();
    // BAD: the user-provided expression is directly evaluated
    MVEL.eval(expression);
  }
}