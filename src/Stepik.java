/**
 Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).
 Во всех остальных случаях метод должен возвращать false.

 Воспользуйтесь шаблоном кода, который предлагает система. Ввод-вывод будет сделан за вас.
 Вам надо только проанализировать переданные в метод booleanExpression значения (a, b, c, d) и вернуть результат.
 Попробуйте составить формулу с использованием булевых операторов. Если не получается, вернитесь к этому заданию после
 просмотра степов про условные операторы и циклы.

 При записи сложных выражений рекомендуется использовать скобки, чтобы не запутаться в порядке применения операторов.

 В качестве примера уже указано заведомо некорректное решение задачи. Исправьте его.

 Совет тем, у кого не проходит какой-то из тестов. В данной задаче возможно всего 16 комбинаций значений входных параметров.
 Их можно выписать на бумажку, посчитать для них правильные ответы и сравнить с тем, что выдает ваше решение.
 Попробуйте самостоятельно проделать это, найти ошибку и исправить решение.

 Sample Input 1:
 false false false false
 Sample Output 1:
 false
 Sample Input 2:
 true true true true
 Sample Output 2:
 false
 Sample Input 3:
 false false true true
 Sample Output 3:
 true
 */
public class Stepik {
    public static void main(String[] args) {
int i=1;
        System.out.print(i++);System.out.println(booleanExpression(false, false,false,false)?"!":"");
        System.out.print(i++);System.out.println(booleanExpression(false, false,false,true)?"!":"");
        System.out.print(i++);System.out.println(booleanExpression(false, false,true,false)?"!":"");

        System.out.print(i++);System.out.println(booleanExpression(false, false,true,true)?"!":"");

        System.out.print(i++);System.out.println(booleanExpression(false, true,false,false)?"!":"");
        System.out.print(i++);System.out.println(booleanExpression(false, true,false,true)?"!":"");

        System.out.print(i++);System.out.println(booleanExpression(false, true,true,false)?"!":"");

        System.out.print(i++);System.out.println(booleanExpression(false, true,true,true)?"!":"");

        System.out.print(i++);System.out.println( booleanExpression(true, false,false,false)?"!":"");
        System.out.print(i++);System.out.println( booleanExpression(true, false,false,true)?"!":"");
        System.out.print(i++);System.out.println( booleanExpression(true, false,true,false)?"!":"");

        System.out.print(i++);System.out.println( booleanExpression(true, false,true,true)?"!":"");

        System.out.print(i++);System.out.println( booleanExpression(true, true,false,false)?"!":"");

        System.out.print(i++);System.out.println( booleanExpression(true, true,false,true)?"!":"");
        System.out.print(i++);System.out.println( booleanExpression(true, true,true,false)?"!":"");
        System.out.print(i++);System.out.println( booleanExpression(true, true,true,true)?"!":"");

    }
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        if (a) {
            if (b){
                if (!c&!d)
                return a&&b;
            }
            if (c) {
                if (!b&!d)
                return a&&c;
            }
            if (d) {
                if (!b&!c)
                return a&&d;
            }
        }
        else {
            if (b){
                if (c&!d) {
                    return b & c;
                }
                return false;
            }
            if (c){
                if (d) return c&d;
            }

        }

        return false;
    }

}
