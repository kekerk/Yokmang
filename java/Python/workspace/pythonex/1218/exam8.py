#문자를 '(내용)' 형태로 입력받기로 함.  () 입력을 안하면 ( ) 추가하기

print("내용을 입력하세요")
text = input()
if not text.startswith("(") :
    print("문자의 앞에 '('를 추가합니다.")
    text = "(" + text
if not text.endswith(")") :
    print("문자의 끝에 ')'를 추가합니다.")
    text = text + ")"
print("출력:",text)