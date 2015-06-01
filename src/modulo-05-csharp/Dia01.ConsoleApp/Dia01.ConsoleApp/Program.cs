using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp
{
    class Program
    {
        string _variavel;//Por padrão é private

        static void Main(string[] args)
        {

            #region dynamic
            dynamic oi = "Ta se loco!";
            oi += 10;

            Console.WriteLine(oi);

            #region object

            /*dynamic oi2 = new Object();
            oi2.Saudacao = "Ta se loco!";

            Console.WriteLine(oi2);*/

            #endregion

            dynamic oi3 = new ExpandoObject();
            oi3.Saudacao = "Ta se loco!";

            Console.WriteLine(oi3.Saudacao);
            #endregion

            #region Arraiii
            var numeros = new[] { 1, 2, 3 }.ToList();
            //IList<int> numeros = new List<int>(new [] { 1, 2, 3 });
            //numeros.AddRange(new[] { 1, 2, 3});
            //var numeros = new List<int>(capacity: 10); // capacity - aloca um espaço inicial em memória
            //var numeros = new List<int>(/*capacity*/10);
            numeros.Add(4);

            //string str1 = "Ana";

            //for (int i = 0; i < 10000; i++)
            //{
            //    Console.WriteLine(i);
            //}

            foreach (var i in numeros)
            {
                Console.WriteLine(i);
            }

            numeros.ForEach((i) =>
            {
                Console.WriteLine(i);
            });

            Action<int> imprimir = i => Console.WriteLine(i + " Bacon");
            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);
            new[] { 8, 9, 10 }.ToList().ForEach(imprimir);

            #endregion

            #region Extension Methods

            Console.WriteLine("Ana".ToBacon());

            #endregion

            #region Jedi

            //var yoda = new Jedi();
            //yoda.Name = "Yoda";
            var yoda = new Jedi()
            {
                Name = "Yoda",
                Grau = Grau.MESTRE
            };

            var baconJedi = new
            {
                Name = yoda.Name.ToBacon()
            };

            Console.WriteLine(yoda.Name);

            #endregion

            #region DateTime

            DateTime agora = DateTime.Now;

            #endregion

            Console.ReadKey();
        }
    }
}
